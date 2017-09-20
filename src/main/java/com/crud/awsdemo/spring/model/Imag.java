package com.crud.awsdemo.spring.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="imgs")
public class Imag implements Serializable {



    @ManyToOne
    @JoinColumn(name="prsn_id", nullable=false, insertable=false, updatable=false)
    private Person person;

    @Id
    @Column (name="id", nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private byte[] img;

    @Column
    private int prsn_id;

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


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrsn_id() {
        return prsn_id;
    }

    public void setPrsn_id(int prsn_id) {
        this.prsn_id = prsn_id;
    }

}
