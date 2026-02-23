package com.taller.ciciddemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.MockMvc;

//import static java.lang.reflect.Array.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSum() throws Exception {
        mockMvc.perform(get("/api/sum")
                        .param("a", "3")
                        .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));
    }

    @Test
    void testMultiply() throws Exception {
        mockMvc.perform(get("/api/multiply")
                        .param("a", "3")
                        .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("12"));
    }

    @Test
    void testHealthCheck() throws Exception {
        mockMvc.perform(get("/api/health-check"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }
}
