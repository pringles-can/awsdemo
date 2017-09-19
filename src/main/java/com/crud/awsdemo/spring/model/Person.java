package com.crud.awsdemo.spring.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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

    @OneToMany(mappedBy = "person") // mapped by person in Imag
    private Set<Imag> imgs;

    public Person(int id, String name) {

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

    public void setImgs(Set<Imag> imags) {
        this.imgs = imags;
    }

    public Set<Imag> getImgs() {
        return this.imgs;
    }

    @Override
    public String toString() {
        return "id="+id+", name="+name+", country="+country;
    }

}
