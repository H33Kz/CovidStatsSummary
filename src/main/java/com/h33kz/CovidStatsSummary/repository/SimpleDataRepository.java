package com.h33kz.CovidStatsSummary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.h33kz.CovidStatsSummary.models.Simpledata;

import jakarta.transaction.Transactional;

@Repository
public interface SimpleDataRepository extends JpaRepository<Simpledata, Long> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE Simpledata;", nativeQuery = true)
    void deleteBeforeUpdate();
}
