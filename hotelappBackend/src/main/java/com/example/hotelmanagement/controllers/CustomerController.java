package com.example.hotelmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelmanagement.services.CustomerService;
import com.example.hotelmanagement.entities.Customer;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("getAllCustomers")
    public List<Customer> readAllCustomers(){
        return customerService.readAllCustomers();
    }
    
    @GetMapping("getCustomerByEmail/{email}")
    public Customer readCustomer(@PathVariable String email){
        return customerService.readCustomerByEmail(email);
    }

    @PostMapping("createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Long id){
        if(Boolean.TRUE.equals(customerService.deleteCustomer(id))){
            return "Deleted Successfully";
        }else{
            return "Data not found!";
        }
    }
}
