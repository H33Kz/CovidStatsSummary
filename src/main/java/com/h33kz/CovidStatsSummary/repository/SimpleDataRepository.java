package com.h33kz.CovidStatsSummary.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.h33kz.CovidStatsSummary.models.Simpledata;

import jakarta.transaction.Transactional;

@Repository
public interface SimpleDataRepository extends JpaRepository<Simpledata, Long> {
  @Modifying
  @Transactional
  @Query(value = "TRUNCATE TABLE Simpledata;", nativeQuery = true)
  void deleteBeforeUpdate();
  
  @Query(value = "SELECT * from Simpledata where name=:selectedName",nativeQuery = true)
  ArrayList<Simpledata> getSingleCountry(@Param("selectedName") String selectedName);
  
}
