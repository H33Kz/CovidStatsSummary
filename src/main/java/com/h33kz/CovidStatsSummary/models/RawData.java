package com.h33kz.CovidStatsSummary.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RawData {
  private String FIPS;
  private String Admin2;
  private String Provinence_State;
  private String Country_Region;
  private String Last_Update;
  private String Lat;
  private String Long_;
  private String Confirmed;
  private String Deaths;
  private String Recovered;
  private String Active;
  private String Combined_Key;
  private String Incident_Rate;
  private String Case_Fatality_Ratio;
}
