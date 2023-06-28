package com.h33kz.CovidStatsSummary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h33kz.CovidStatsSummary.models.Simpledata;

@Repository
public interface SimpleDataRepository extends JpaRepository<Simpledata, Long> {
}
