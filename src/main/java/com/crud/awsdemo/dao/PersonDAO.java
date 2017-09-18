package com.crud.awsdemo.dao;

import java.util.List;
import com.crud.awsdemo.spring.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer>{

    Person findByName(String name);
    Page findAll(Pageable pageable);

}
