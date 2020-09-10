package com.example.coursebooker.controllers;

import com.example.coursebooker.models.Booking;
import com.example.coursebooker.models.Customer;
import com.example.coursebooker.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "course", required = false) String courseName) {
        if (courseName != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
       customerRepository.save(customer);
       return new ResponseEntity(customer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        customerRepository.save(customer);
        return new ResponseEntity(customer, HttpStatus.CREATED);
    }
}
