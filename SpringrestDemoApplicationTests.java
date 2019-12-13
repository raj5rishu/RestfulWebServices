package com.example.demo;

import com.example.demo.controllers.FirstController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@SpringBootTest
class SpringrestDemoApplicationTests {
    private MockMvc mvc;

    @InjectMocks
    private FirstController firstController;
    @BeforeEach
    public void setup() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(firstController).build();
    }
    @Test
    public void testShowWelcome() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/welcome"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Welcome to Spring Rest Example"));
    }
    @Test
    public void testGetStudents() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/students").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
