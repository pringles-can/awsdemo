package com.crud.awsdemo.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author sprindle
 *
 */

@Entity
@Table(name="PERSON")
public class Person implements Serializable {

    @Id
    @Column(name="id", nullable = false, insertable = false, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    public Person(int id, String name) {
        //this.id = id;
        //this.name = name;

    }

    public Person(String name, String country) {
        this.name = name;
        this.country= country;
    }



    // default; totally works, the debugger's full of shit
    protected Person(){

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    @Override
    public String toString() {
        return "id="+id+", name="+name+", country="+country;
    }

}
