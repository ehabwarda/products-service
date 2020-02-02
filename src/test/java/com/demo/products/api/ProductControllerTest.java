package com.demo.products.api;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGetProductsThenSuccess() throws Exception {
        mockMvc.perform(get("/api/products").with(user(USERNAME).password(PASSWORD)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(4))));
    }

    @Test
    public void whenGetProductByIdThenSuccess() throws Exception {
        mockMvc.perform(get("/api/products/1").with(user(USERNAME).password(PASSWORD)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("HTC 10 EVO"));
    }

    @Test
    public void whenGetProductByNotExistIdThenNotFound() throws Exception {
        mockMvc.perform(get("/api/products/999").with(user(USERNAME).password(PASSWORD)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void whenCreateProductThenReturnCreatedProduct() throws Exception {
        mockMvc.perform(post("/api/products")
                .with(user(USERNAME).password(PASSWORD))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"dummy-product\", \"currentPrice\": 10}"))
                .andExpect(jsonPath("$.name").value("dummy-product"))
                .andExpect(status().isCreated());
    }

}
