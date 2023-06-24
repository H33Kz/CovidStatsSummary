package com.h33kz.CovidStatsSummary.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.h33kz.CovidStatsSummary.models.AllStats;
import com.h33kz.CovidStatsSummary.models.Meta;
import com.h33kz.CovidStatsSummary.models.RawData;

@Service
public class StatsService {
  private static final String API_URL = "https://coronavirus.m.pipedream.net/";

  public ArrayList<RawData> getCountries() throws Exception{
    return callGetMethod().getRawDataList();
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
    System.out.println(aStats.getCache().getLastUpdated());
    return aStats;
  }

}
