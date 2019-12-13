package com.example.demo.repository;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerRepository {
    public List<Customer> findAll();
    public Customer findById(Long id);
    public Customer createCustomer(Customer customer);
    public void delete(Long id);
    public Customer update(Long id, Customer customer);
}
