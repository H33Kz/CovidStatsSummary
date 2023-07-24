package com.h33kz.CovidStatsSummary.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h33kz.CovidStatsSummary.models.Simpledata;
import com.h33kz.CovidStatsSummary.models.Simplesummary;
import com.h33kz.CovidStatsSummary.repository.SimpleDataRepository;
import com.h33kz.CovidStatsSummary.repository.SummaryRepository;

@Service
public class DBStatsService {
  @Autowired
  private SimpleDataRepository dataRepository;
  @Autowired
  private SummaryRepository summaryRepository;
  
  public ArrayList<Simpledata> getSingleCountry(String selectedName){
    return dataRepository.getSingleCountry(selectedName);
  }

  public List<Simpledata> getAll(){
    return dataRepository.findAll();
  }

  public Simplesummary getSummary(){
    return summaryRepository.findAll().get(0);
  }
}
