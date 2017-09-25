package com.crud.awsdemo.dao;


import com.crud.awsdemo.spring.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer>{

    Person findByNameIgnoringCase(String name);
    Page findAll(Pageable pageable);

}
