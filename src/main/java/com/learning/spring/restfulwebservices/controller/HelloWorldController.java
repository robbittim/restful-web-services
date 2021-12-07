package com.learning.spring.restfulwebservices.controller;


import com.learning.spring.restfulwebservices.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/helloWorldBean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping("/helloWorldBean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    //internationalized - work with messages.properties files
    @GetMapping("/helloWorld-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale){

//        Internationalization - i18n
//        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
        return messageSource.getMessage("good.morning.message",null,"Default Message", LocaleContextHolder.getLocale());
    }

}
