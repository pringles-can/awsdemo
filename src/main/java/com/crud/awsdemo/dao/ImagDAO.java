package com.crud.awsdemo.dao;

import com.crud.awsdemo.spring.model.Imag;
import com.crud.awsdemo.spring.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagDAO extends JpaRepository<Imag, Integer> {
    @Query("SELECT img FROM Imag i WHERE i.prsn_id = :prsn_id")
    List<byte[]> findAllById(@Param("prsn_id") int id);
}
