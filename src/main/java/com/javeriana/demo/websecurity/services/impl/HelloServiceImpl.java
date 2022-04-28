package com.javeriana.demo.websecurity.services.impl;

import org.springframework.stereotype.Service;
import com.javeriana.demo.websecurity.services.HelloService;

@Service
public class HelloServiceImpl implements HelloService{
  
  @Override
  public String sayHello() {
    return "hola mundo";
  }
  
  @Override
  public String sayHello(final String name) {
    return "Feliz dia " + name;
  }
}
