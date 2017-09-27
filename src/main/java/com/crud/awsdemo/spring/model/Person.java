package com.crud.awsdemo.spring.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

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
    @Column(name="id", nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, max = 20)
    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL) // mapped by person in Imag
    private List<Imag> imgs;

    public Person(int id, String name) {

    }

    public Person(String name, String country) {
        this.name = name;
        this.country= country;
    }

    // default; totally works, the debugger's full of shit
    public Person(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.toLowerCase();
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

    public void setImgs(List<Imag> imags) {
        this.imgs = imags;
    }

    public List<Imag> getImgs() {
        return this.imgs;
    }

    @Override
    public String toString() {
        return "id="+id+", name="+name+", country="+country;
    }

}
