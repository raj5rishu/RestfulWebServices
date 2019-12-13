package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private List<Customer> customersData;
    CustomerRepositoryImpl(){
        this.customersData = new ArrayList<Customer>();
        customersData.add(new Customer(101L, "Rishav","9334188566"));
        customersData.add(new Customer(102L, "Hiral","8951575132"));
    }
    @Override
    public List<Customer> findAll() {
        return customersData;
    }

    @Override
    public Customer findById(Long id) {
        for (Customer c:customersData) {
            if(c.getId()==id)
                return c;
        }
        return null;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setId(System.currentTimeMillis()%1000);
        customersData.add(customer);
        return customer;
    }

    @Override
    public void delete(Long id) {
        for (Customer c:customersData) {
            if(c.getId()==id)
                customersData.remove(c);
        }
    }

    @Override
    public Customer update(Long id, Customer customer) {
        for(Customer c:customersData){
            if(c.getId()==id){
                customer.setId(c.getId());
                customersData.remove(c);
                customersData.add(customer);
                return customer;
            }
        }
        return null;
    }
}
