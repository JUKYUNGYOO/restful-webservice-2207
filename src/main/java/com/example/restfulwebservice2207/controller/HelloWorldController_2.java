package com.example.restfulwebservice2207.controller;

import com.example.restfulwebservice2207.helloworld.HelloWorldBean_3;
import org.springframework.web.bind.annotation.*;
//2
//Controller
@RestController
public class HelloWorldController_2 {
    //GET
    //URI - /hello-world
    //method -- "Hello World" - localhost:8080/hello-world
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
    //hello-world-bean
//    create HelloWorldBean class
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean_3 helloWorldBean_3(){
        return new HelloWorldBean_3("Hello World");
    }
//localhost:8080/hello-world-bean
//    출력 결과
//    {"message":"Hello World"}

    //localhost:8080/hello-world/path-variable/in28
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean_3 helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean_3(String.format("Hello World, %s", name));
    }

}
