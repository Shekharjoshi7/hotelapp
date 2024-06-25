package com.example.hotelmanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmanagement.entities.Customer;
import com.example.hotelmanagement.repositories.CustomerRepository;
import com.example.hotelmanagement.entities.CustomerEntity;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public String createCustomer(Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setContact(customer.getContact());
        customerEntity.setGender(customer.getGender());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPassword(customer.getPassword());
        customerRepo.save(customerEntity);
        return "Account created successfully";
    }
    @Override
    public List<Customer> readAllCustomers(){
        List<CustomerEntity> custEntity = customerRepo.findAll();
        List<Customer> customer = new ArrayList<>();
        for(CustomerEntity c : custEntity){
            Customer cust = new Customer();
            cust.setCustomerId(c.getCustomerId());
            cust.setName(c.getName());
            cust.setContact(c.getContact());
            cust.setGender(c.getGender());
            cust.setEmail(c.getEmail());
            cust.setPassword(c.getPassword());
            customer.add(cust);
        }
        return customer;
        
    }
    @Override
    public boolean deleteCustomer(Long id){
       Optional<CustomerEntity> cust = customerRepo.findById(id);
       if(cust.isPresent()){
        CustomerEntity custdel = cust.get();
        customerRepo.delete(custdel);
        return true;
       }else{
        return false;
       }
    }
    @Override
    public String updateCustomer(Long id, Customer customer){
        Optional<CustomerEntity> cust = customerRepo.findById(id);
        if(cust.isPresent()){
            CustomerEntity custAdd = cust.get();
            customerRepo.save(custAdd);
            return "Updated";
        }else{
            return "Not Found";
        }
    }
    @Override
    public Customer readCustomer(Long id){
        Optional<CustomerEntity> cust = customerRepo.findById(id);
        Customer customer = new Customer();
        if(cust.isPresent()){
            BeanUtils.copyProperties(customer, cust);
            return customer;
       }else{
            return null;
       }
    }

    @Override
    public  Customer readCustomerByEmail(String email){
        Optional<CustomerEntity> custOpt = customerRepo.findByEmail(email);
        Customer customer = new Customer();
        if (custOpt.isPresent()) {
            BeanUtils.copyProperties(custOpt.get(), customer);
            return customer;
        } else {
            return null;  // Return null or throw an exception if not found
        }
    }
}
