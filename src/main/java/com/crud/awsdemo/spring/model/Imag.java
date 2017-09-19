package com.crud.awsdemo.spring.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="imgs")
public class Imag implements Serializable {

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Person person;

    @Id
    @Column (name="id", nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private byte[] img;

    public Imag() {}

    public Imag(byte[] img) {
        this.img = img;
    }

    public int getImagId() {
        return this.id;
    }

    public byte[] getImg() {
        return this.img;
    }

    public void setImg(byte[] image) {
        this.img = image;
    }






}
