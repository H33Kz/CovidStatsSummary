package com.h33kz.CovidStatsSummary.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h33kz.CovidStatsSummary.models.Simpledata;
import com.h33kz.CovidStatsSummary.service.DBStatsService;

@RestController
@RequestMapping("/db")
public class DBStatsController {
  @Autowired
  private DBStatsService statsService;
  
  @GetMapping("getCountry/{selectedName}")
  public ArrayList<Simpledata> getSingleCountry(@PathVariable String selectedName){
    return statsService.getSingleCountry(selectedName);
  }

  @GetMapping("getAll")
  public List<Simpledata> getAll(){
    return statsService.getAll();
  }
}
