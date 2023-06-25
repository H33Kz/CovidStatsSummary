package com.h33kz.CovidStatsSummary.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h33kz.CovidStatsSummary.models.RawData;
import com.h33kz.CovidStatsSummary.models.AllStats;
import com.h33kz.CovidStatsSummary.models.Meta;
import com.h33kz.CovidStatsSummary.service.StatsService;

@RestController
@RequestMapping("/")
@CrossOrigin
class StatsController {

  @Autowired
  private StatsService statsService;

  @GetMapping("/getAll")
  public AllStats getAll() throws Exception{
    return statsService.getAll();
  }

  @GetMapping("/getCountries")
  public ArrayList<RawData> getCountries() throws Exception{
    return statsService.getCountries();
  }

  @GetMapping("/getMetaData")
  public Meta getMetaData() throws Exception{
    return statsService.getMetaData();
  }

  @GetMapping("/getCountry/{name}")
  public ArrayList<RawData> getCountry(@PathVariable String name) throws Exception{
    return statsService.getCountry(name);
  }
}
