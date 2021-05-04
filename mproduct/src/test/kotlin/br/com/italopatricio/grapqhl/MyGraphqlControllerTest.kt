package br.com.italopatricio.grapqhl

import com.netflix.graphql.dgs.DgsQueryExecutor
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [DgsAutoConfiguration::class, MyGraphqlController::class])
class MyGraphqlControllerTest {
    @Autowired
    lateinit var dgsQueryExecutor: DgsQueryExecutor

    @Test
    fun products() {
        val titles : List<String> = dgsQueryExecutor.executeAndExtractJsonPath("""
            {
                products {
                    title
                }
            }
        """.trimIndent(), "data.products[*].title")

        assertThat(titles).contains("Produto EE")
    }

    @Test
    fun productsWithBuyer() {
        val titles : List<String> = dgsQueryExecutor.executeAndExtractJsonPath("""
            {
                products {
                    title
                    buyer {
                       name
                    }
                }
            }
        """.trimIndent(), "data.products[*].title")

        assertThat(titles).contains("Produto EE")
    }
}