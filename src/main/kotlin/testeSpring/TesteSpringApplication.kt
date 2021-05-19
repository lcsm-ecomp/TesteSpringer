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
    @GetMapping("/") 
    fun paginaInicial() : String { 
    println("ola para todos")
    return """
        <html>
        <title>Página Inicial do Sistema</title>
        <body>
        Este é um exemplo de página gerada por um programa em 
        kotlin. Esse programa foi executado no servidor web.
        Apesar de ser gerada por um programa ela é estática<p>
        <a href="pagina_estatica.html">Outra Página estática</a><p>
        <a href="pagina_dinamica.html">Página Gerada Dinamicamente</a><p>
        </body>
        </html>
        """
    }
    
    @GetMapping("/pagina_dinamica.html")
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
