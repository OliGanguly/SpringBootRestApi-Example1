package com.example.SpringBootRestApiBook.ORM.OneToOne.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int address_id;
    private String address_name;
    public Address() {
    }

    public Address(int address_id, String address_name) {
        this.address_id = address_id;
        this.address_name = address_name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", address_name='" + address_name + '\'' +
                '}';
    }
}
