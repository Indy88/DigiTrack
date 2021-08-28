package com.digitrack.crudperson.repository;

import com.digitrack.crudperson.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
//import org.springframework.data.repository.CrudRepository;

@Repository
public interface PersonRepository  extends PagingAndSortingRepository<Person, Long> {

    @Query("From Person p WHERE p.fullname LIKE %:searchText%")
    Page<Person> findAllPerson(Pageable pageable,   @Param("searchText") String searchText);

    @Query("From Person p WHERE p.sex=:sex")
    Page<Person> findBySex(Pageable pageable, @Param("sex") boolean sex);

    @Query("From Person p WHERE p.datebirth=:datebirth")
    Page<Person> findByDatebirth(Pageable pageable, @Param("datebirth") Date datebirth);




}

