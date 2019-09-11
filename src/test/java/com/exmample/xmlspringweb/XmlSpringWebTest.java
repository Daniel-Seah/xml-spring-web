package com.exmample.xmlspringweb;

import com.example.xmlspringweb.Application;
import com.example.xmlspringweb.SchemaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc
public class XmlSpringWebTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private SchemaRepository repo;

    @Test
    public void shouldReturnSchema_whenRequestingForKnownType() throws Exception {
        when(repo.findSchemaByType("abc")).thenReturn("<?xml version=\"1.0\" encoding=\"UTF-8\"?><note2>abc</note2>");
        mvc.perform(get("/").param("type", "abc"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml("<?xml version=\"1.0\" encoding=\"UTF-8\"?><note2>abc</note2>"));
    }
}
