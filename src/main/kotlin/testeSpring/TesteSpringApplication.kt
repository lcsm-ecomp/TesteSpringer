package testeSpring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@SpringBootApplication
class TesteSpringApplication {
   
}

var numero = 0

@RestController
class MessageResource {
    @GetMapping("/ola.html")
    fun old(@RequestParam(value = "name", defaultValue = "todos") name:String): String = """
    <html> <title>Ola</title>
    <body> Ola $name,
    <p>
    Você já acessou a página ${numero++} vezes.
    </body> </html>
    """
}

fun main(args: Array<String>) {
	runApplication<TesteSpringApplication>(*args)
}
