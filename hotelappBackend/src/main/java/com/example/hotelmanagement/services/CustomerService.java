package com.example.hotelmanagement.services;

import java.util.*;

import com.example.hotelmanagement.entities.Customer;
public interface CustomerService{
    String createCustomer(Customer customer);
    List<Customer> readAllCustomers();
    boolean deleteCustomer(Long id);
    String updateCustomer(Long id, Customer customer);
    Customer readCustomer(Long id);
    Customer readCustomerByEmail(String email);
} 