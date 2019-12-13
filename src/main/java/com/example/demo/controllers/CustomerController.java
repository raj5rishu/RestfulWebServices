package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> showCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> showCustomerById(@PathVariable("id") Long id){
        Customer customer = customerService.getCustomerById(id);
        if(customer==null){
            return new ResponseEntity<String>("No Customer Id found: "+id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.createCustomer(customer), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        try{
            customerService.deleteCustomer(id);
            return new ResponseEntity<String>("Deleted customer with id: "+id,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("id not found:"+id, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        if(updatedCustomer == null){
            return new ResponseEntity<String>("Customer id not found:"+id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }
    @GetMapping("/byname")
    public ResponseEntity<?> getCustomersByName(@RequestParam("name") String customerName){
        List<Customer> allCustomers = customerService.getCustomersByName(customerName);
        return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);
    }
    @GetMapping("/contact/{contact}")
    public ResponseEntity<?> getCustomersByContact(@PathVariable("contact") String contactNumber){
        return new ResponseEntity<List<Customer>>(customerService.fetchCustomersByContact(contactNumber), HttpStatus.OK);
    }
}
