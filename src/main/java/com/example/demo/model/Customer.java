package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Customer {
    @Id
    private long id;
    private String name;
    private String contactnumber;

    public Customer(){}
    public Customer(long id, String name, String contactnumber) {
        this.id = id;
        this.name = name;
        this.contactnumber = contactnumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }
}
