package com.company.customerdataservice.repositories;


import com.company.customerdataservice.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CustomerRepositoryTest {


    @Autowired
    CustomerRepository repo;


    @BeforeEach
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    //Create a new customer record. 5 pts -----------GOOOOOOD
    //
    //Update an existing customer record. 5 pts----- GOOOD
    //
    //Delete an existing customer record. 5 pts ------ GOOOOOOD
    //
    //Find a customer record by id. 5 pts   ----- GOOOOOOD
    //
    //Find customer records by state. 5 pts ------- GOOOOOD



    @Test
    public void shouldAddCustomer() {
        //Arrange
        Customer customer = new Customer();
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

        customer = repo.save(customer);
        Optional<Customer> fromRepo = repo.findById(customer.getId());
        //Act
        //Assert
        assertEquals(customer, fromRepo.get());
    }


    @Test
    public void shouldUpdateCustomer() {

        //Arrange
        Customer customer = new Customer();
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
        //Act
        customer = repo.save(customer);

        //Assert
        Optional<Customer> fromRepo = repo.findById(customer.getId());
        assertEquals(customer, fromRepo.get());


    }

    @Test
    public void shouldDeleteCustomer() {
        //Arrange
        Customer customer = new Customer();
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

        customer = repo.save(customer);

        //Act
        Optional<Customer> fromRepo = repo.findById(customer.getId());//repository goes in db to find that specific customer and returnss Optional
        assertEquals(fromRepo.get(), customer);// asserts that the customer initially exists in the db

        repo.deleteById(customer.getId()); // deletes the customer from the db

        fromRepo = repo.findById(customer.getId()); // goes back to the db to find the customer by id

        //Assert
        assertFalse(fromRepo.isPresent());// asserts that the customer is no longer in the db

    }

    @Test
    public void shouldFindCustomerById() {
        //Arrange
        Customer customer = new Customer();
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

        customer = repo.save(customer);

        //act
        Optional<Customer> foundCustomer = repo.findById(customer.getId());

        //assert
        assertEquals(foundCustomer.get(), customer);
    }

    @Test
    public void shouldGetCustomerByState(){
        //Arrange
        Customer customer = new Customer();
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

        customer = repo.save(customer);

        //Act
        List<Customer> foundCustomers = repo.findByState(customer.getState());

        //Asserrt
        assertEquals(foundCustomers.size(), 1);
    }

    @Test
    public void shouldGetAllCustomers() {
        //Arrange
        Customer customer = new Customer();
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

        customer = repo.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Jane");
        customer2.setLastName("Doe");
        customer2.setEmail("janeDoe@gmail.com");
        customer2.setCompany("ABC Company");
        customer2.setPhone("123-456-7892");
        customer2.setAddress1("123 Main Street");
        customer2.setAddress2("Suite 100");
        customer2.setCity("Anytown");
        customer2.setState("NY");
        customer2.setPostalCode("12345");
        customer2.setCountry("USA");

        customer2 = repo.save(customer2);

        //Act
        List<Customer> customers = repo.findAll();
        //Assert
        assertEquals(customers.size(), 2);


        // Delete an existing customer record
        //Find a customer record by id
        // find customer records by state
    }
}

