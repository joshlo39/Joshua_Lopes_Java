package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;

    @BeforeEach
    public void setUp(){
        customer = new Customer(1, "John");
    }

    @Test
    public void shouldGetBalance(){
        customer.getCharges().add(new AccountRecord(5000, "01/01/2020"));
        customer.getCharges().add(new AccountRecord(20000, "01/02/2020"));
        customer.getCharges().add(new AccountRecord(-10000, "01/03/2020"));
        assertEquals(15000, customer.getBalance());
    }

    @Test
    public void shouldReturnString(){
        customer.getCharges().add(new AccountRecord(50000, "01/01/2020"));
        customer.getCharges().add(new AccountRecord(20000, "01/02/2020"));
        customer.getCharges().add(new AccountRecord(-20000, "01/03/2020"));
        assertEquals("Customer Name: John\t\tCustomerId: 1\t\tBalance: 50000", customer.toString());
    }

}