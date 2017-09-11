package com.crud.awsdemo.service;

import java.util.List;

import com.crud.awsdemo.spring.model.Person;

public interface PersonService {


    public void addPerson(Person prsn);
    public void updatePerson(Person prsn);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);

}
