package com.example.xmlspringweb;

import org.springframework.stereotype.Service;

@Service
public class SchemaRepository {
    public String findSchemaByType(String type) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<note>" + type + "</note>";
    }
}
