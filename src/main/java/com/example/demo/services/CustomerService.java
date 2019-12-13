package com.example.demo.services;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public Customer getCustomerById(Long id);
    public Customer createCustomer(Customer customer);
    public void deleteCustomer(Long id);
    public Customer updateCustomer(Long id, Customer customer);
    public List<Customer> getCustomersByName(String name);
    public List<Customer> fetchCustomersByContact(String contactnumber);
}
