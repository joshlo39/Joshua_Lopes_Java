package com.company.customerdataservice.controllers;

import com.company.customerdataservice.models.Customer;
import com.company.customerdataservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repo;

    //Create
    @PostMapping("/customers")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }
    //Read
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Optional<Customer> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }
    @GetMapping("/customers/state/{state}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Customer> getCustomersByState(@PathVariable String state) {
        return repo.findByState(state);
    }

    //Update
    @PutMapping("/customers/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
        repo.save(customer);
    }

    // Delete
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }


}
