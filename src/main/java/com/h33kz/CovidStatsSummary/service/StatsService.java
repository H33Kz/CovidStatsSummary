package com.h33kz.CovidStatsSummary.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.h33kz.CovidStatsSummary.models.AllStats;
import com.h33kz.CovidStatsSummary.models.Meta;
import com.h33kz.CovidStatsSummary.models.RawData;
import com.h33kz.CovidStatsSummary.models.SummaryStats;

@Service
public class StatsService {
  private static final String API_URL = "https://coronavirus.m.pipedream.net/";
  
  public ArrayList<RawData> getCountry(String name) throws Exception{
    ArrayList<RawData> allData = callGetMethod().getRawData();
    ArrayList<RawData> resultList = new ArrayList<RawData>();
    for (RawData iterator : allData) {
      if(iterator.getCountry_Region().equals(name)){
        resultList.add(iterator);
      }
    }
    return resultList;
  }

  public SummaryStats getSummary() throws Exception{
    return callGetMethod().getSummaryStats();
  }

  public ArrayList<RawData> getCountries() throws Exception{
    return callGetMethod().getRawData();
  }

  public Meta getMetaData() throws Exception{
    return callGetMethod().getCache();
  }

  public AllStats getAll() throws Exception{
    return callGetMethod();
  }

  private AllStats callGetMethod() throws Exception{
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(API_URL)).GET().build();
    HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());

    Gson gson = new Gson();
    AllStats aStats = gson.fromJson(response.body(), AllStats.class);
    return aStats;
  }

}
