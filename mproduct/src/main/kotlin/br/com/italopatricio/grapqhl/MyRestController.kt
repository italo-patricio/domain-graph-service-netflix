package br.com.italopatricio.grapqhl

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyRestController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello world Graphql"
    }
}