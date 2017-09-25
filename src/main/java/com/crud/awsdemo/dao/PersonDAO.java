package com.crud.awsdemo.dao;


import com.crud.awsdemo.spring.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer>{
    // @valids
    // search: filter main list, "none found"
    // paging for edit
    // edit IDs on home to take you to details
    // make UI better
    Person findByNameIgnoringCase(String name);
    Page findAll(Pageable pageable);
    Page findAllOrderById(Pageable pageable);

}
