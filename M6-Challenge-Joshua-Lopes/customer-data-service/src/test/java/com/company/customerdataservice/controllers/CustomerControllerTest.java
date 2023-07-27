package com.company.customerdataservice.controllers;

import com.company.customerdataservice.controllers.CustomerController;
import com.company.customerdataservice.models.Customer;
import com.company.customerdataservice.repositories.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CustomerController.class)
class CustomerControllerTest{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepo;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    Customer customer = new Customer();
    String inputJson;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepo.deleteAll();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@gmail.com");
        customer.setCompany("ABC Company");
        customer.setPhone("123-456-7890");
        customer.setAddress1("123 Main Street");
        customer.setAddress2("Suite 100");
        customer.setCity("Anytown");
        customer.setState("NY");
        customer.setPostalCode("12345");
        customer.setCountry("USA");
        inputJson = mapper.writeValueAsString(customer);
    }

    //A POST route that creates a new customer. 10 pts ----- GOOOOOD
    //
    //A PUT route that updates an existing customer. 10 pts ---GOOOOOD
    //
    //A DELETE route that deletes an existing customer. 10 pts ----Gooood
    //
    //A GET route that returns a specific customer by id. 10 pts ---- GOOOOOD
    //
    //A GET route that returns all customers for a specific state. 10 pts ----- GOOOOOOd

    @Test
    public void shouldAddCustomer() throws Exception {
        mockMvc.perform(
                post("/customers")
                        .content(inputJson)
                        .contentType("application/json")
        )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        mockMvc.perform(
                put("/customers/{id}",customer.getId())
                        .content(inputJson)
                        .contentType("application/json")
                        .accept("application/json")
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteCustomer() throws Exception{
        mockMvc.perform(
                delete("/customers/{id}",customer.getId())
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetCustomerById() throws Exception{
        mockMvc.perform(
                get("/customers/{id}",customer.getId())
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCustomersByState() throws Exception{
        mockMvc.perform(
                get("/customers/state/{state}",customer.getState())
        )
                .andDo(print())
                .andExpect(status().isOk());
    }



}
