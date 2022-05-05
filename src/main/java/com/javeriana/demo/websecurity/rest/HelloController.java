package com.javeriana.demo.websecurity.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javeriana.demo.websecurity.annotations.IsAdmin;
import com.javeriana.demo.websecurity.annotations.IsCustomer;
import com.javeriana.demo.websecurity.services.HelloService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api")
@AllArgsConstructor
@IsAdmin
public class HelloController {

  HelloService service;

  @GetMapping("hello")
  public String sayHello() {
    return service.sayHello();
  }
  
  @GetMapping("hello/{name}")
  public String sayHelloRecargado(@PathVariable("name") String name) {
    return service.sayHello(name);
  }
  
  @IsCustomer
  @GetMapping("helloCustomer")
  public String sayHelloCustomer() {
    return "Hello Customer. Welcome Again";
  }
  
  @GetMapping("helloUser")
  public String sayHelloUser() {
    return "Hello User. Welcome Again";
  }
}
