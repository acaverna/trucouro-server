package br.com.trucouro.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller("/hello")
class HelloController {

    @Get(produces = [MediaType.TEXT_PLAIN])
    fun hello():String{
        return "Hello World!"
    }

    @Get("/{name}", produces = [MediaType.TEXT_PLAIN])
    fun hello(@PathVariable name:String):String{
        return "Hello $name"
    }

}