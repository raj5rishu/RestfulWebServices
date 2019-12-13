package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Long> {
    public List<Customer> findByName(String name);
    @Query("Select c from Customer c where c.contactnumber=:contact")
    public List<Customer> fetchCustomer(@Param("contact") String contact);
}
