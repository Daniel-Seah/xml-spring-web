package com.example.xmlspringweb;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public String index() {
        return "Greetings from Spring Boot!";
    }
}