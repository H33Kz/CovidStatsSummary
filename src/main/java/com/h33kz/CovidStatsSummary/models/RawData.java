package com.h33kz.CovidStatsSummary.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RawData {
  private String FIPS;
  private String Admin2;
  private String Province_State;
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
