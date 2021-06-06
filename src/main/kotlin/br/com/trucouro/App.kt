package br.com.trucouro

import io.micronaut.runtime.Micronaut

class App {
}

fun main(args: Array<String>) {
    Micronaut.run(App::class.java, *args)
}