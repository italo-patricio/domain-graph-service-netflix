package br.com.italopatricio.grapqhl

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyRestControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Assert api rest is work`() {
        val entity = restTemplate.getForEntity<String>("/hello")
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(entity.body).isEqualTo("Hello world Graphql")
    }
}