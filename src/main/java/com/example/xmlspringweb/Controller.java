package com.example.xmlspringweb;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final SchemaRepository schemaRepo;

    public Controller(SchemaRepository schemaRepo) {
        this.schemaRepo = schemaRepo;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public String index(@RequestParam(value = "type") String type) {
        return schemaRepo.findSchemaByType(type);
    }
}