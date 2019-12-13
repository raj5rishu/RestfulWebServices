package com.example.demo.services;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerDAO;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerDAO customerDAO) {
        this.customerRepository = customerRepository;
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        return (List<Customer>) customerDAO.findAll();
//        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerDAO.findById(id);
        if(optionalCustomer.isPresent())
            return optionalCustomer.get();
        return null;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerDAO.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        return customerDAO.findByName(name);
    }

    @Override
    public List<Customer> fetchCustomersByContact(String contactnumber) {
        return customerDAO.fetchCustomer(contactnumber);
    }

}
