package com.h33kz.CovidStatsSummary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.h33kz.CovidStatsSummary.models.Simplesummary;

import jakarta.transaction.Transactional;


@Repository
public interface SummaryRepository extends JpaRepository<Simplesummary, Integer>{
  @Modifying
  @Transactional
  @Query(value = "TRUNCATE TABLE Simplesummary;", nativeQuery = true)
  void deleteBeforeUpdate();
  
}
