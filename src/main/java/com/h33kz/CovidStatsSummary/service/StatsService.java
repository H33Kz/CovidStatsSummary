package com.h33kz.CovidStatsSummary.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.h33kz.CovidStatsSummary.models.AllStats;
import com.h33kz.CovidStatsSummary.models.Cases;
import com.h33kz.CovidStatsSummary.models.Meta;
import com.h33kz.CovidStatsSummary.models.RawData;
import com.h33kz.CovidStatsSummary.models.Simpledata;
import com.h33kz.CovidStatsSummary.models.Simplesummary;
import com.h33kz.CovidStatsSummary.repository.SimpleDataRepository;
import com.h33kz.CovidStatsSummary.repository.SummaryRepository;


@Service
public class StatsService {

  @Autowired
  private SimpleDataRepository dataRepository;

  @Autowired
  private SummaryRepository summaryRepository;

  private static final String API_URL = "https://coronavirus.m.pipedream.net/";

  public ArrayList<RawData> getCountry(String name) throws Exception {
    ArrayList<RawData> allData = callGetMethod().getRawData();
    ArrayList<RawData> resultList = new ArrayList<RawData>();
    for (RawData iterator : allData) {
      if (iterator.getCountry_Region().equals(name)) {
        resultList.add(iterator);
      }
    }
    return resultList;
  }

  public ArrayList<RawData> getCountries() throws Exception {
    return callGetMethod().getRawData();
  }

  public Meta getMetaData() throws Exception {
    return callGetMethod().getCache();
  }

  public Cases getGlobalSummary() throws Exception{
    return callGetMethod().getSummaryStats().getGlobal();
  }

  public AllStats getAll() throws Exception {
    return callGetMethod();
  }

  private AllStats callGetMethod() throws Exception {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(API_URL)).GET().build();
    HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());

    Gson gson = new Gson();
    AllStats aStats = gson.fromJson(response.body(), AllStats.class);
    return aStats;
  }

  public void updateDB() throws Exception {
    AllStats aStats = callGetMethod();
    ArrayList<RawData> data = aStats.getRawData();
    ArrayList<Simpledata> newData = new ArrayList<>();
    
    for(RawData iterator : data){
      Simpledata entry = new Simpledata();
      entry.setConfirmed(Long.parseLong(iterator.getConfirmed()));
      entry.setDeaths(Long.parseLong(iterator.getDeaths()));
      entry.setName(iterator.getCountry_Region());
      newData.add(entry);
    }


    HashMap<String,Simpledata> map = new HashMap<>();

    for(Simpledata iterator : newData){
      String name = iterator.getName();
      if(map.containsKey(name)){
        Simpledata other = map.get(name);
        other.setDeaths(other.getDeaths() + iterator.getDeaths());
        other.setConfirmed(other.getConfirmed() + iterator.getConfirmed());
      }else{
        map.put(name, iterator);
      }
    }
    newData = new ArrayList<>(map.values());

    for (Simpledata iterator : newData){
      dataRepository.save(iterator);
    }

 
    Simplesummary summary = new Simplesummary();
    summary.setConfirmed(aStats.getSummaryStats().getGlobal().getConfirmed());
    summary.setDeaths(aStats.getSummaryStats().getGlobal().getDeaths());
    summaryRepository.save(summary);
  }

  public void deleteDBContents() {
    dataRepository.deleteBeforeUpdate();
    summaryRepository.deleteBeforeUpdate();
  }

}
