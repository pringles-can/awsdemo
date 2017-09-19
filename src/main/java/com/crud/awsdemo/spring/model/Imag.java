package com.crud.awsdemo.spring.model;


import javax.persistence.*;

@Entity
@Table(name="IMGS")
public class Imag {

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Person person;

    @Id
    @Column (name="id", nullable = false, insertable = false, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private byte[] img;

    public Imag() {}

    public Imag(byte[] img) {
        this.img = img;
    }









}
