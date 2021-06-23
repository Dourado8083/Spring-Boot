package com.helloword.hello.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/hello")
public class HelloController {
@GetMapping
public String helo() {
return "Hello Generation";
}
}
