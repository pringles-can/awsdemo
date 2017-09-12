package com.crud.awsdemo.repository;

import com.crud.awsdemo.spring.model.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
