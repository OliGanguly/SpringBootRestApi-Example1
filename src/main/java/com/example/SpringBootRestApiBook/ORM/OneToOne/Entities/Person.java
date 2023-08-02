package com.example.SpringBootRestApiBook.ORM.OneToOne.Entities;

import com.example.SpringBootRestApiBook.ORM.OneToOne.Entities.Address;
import jakarta.persistence.*;

/*
* If we want to build one-to-one relationship between person and address
* person - parent , address- child
* */
@Entity
@Table(name = "person_table")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String name;

    /*
    * Person - parent
    * Adrress- child
    * fetch - fetch type , do u want to child entities eagerly or lazy way
    * when I will be fetching data from parent table , child table data automatically fetch or not
    * which we defined by fetch type
    *
    * cascade : Since we have a parent child relationship here,
    * I need to tell my spring data jpa any operattion we will be doing in
    * parent does that same cascaded to be child also
    *
    * targetEntity = Address.class
    *
    * */

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL , targetEntity = Address.class)
    @JoinColumn(name = "address_id" , referencedColumnName = "address_id",nullable = false)
                      //person            //address
    private Address address;
    public Person(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
/*
* Bidiectional mapping:
* if book has author
* and author has book
* */
