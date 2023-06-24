package com.h33kz.CovidStatsSummary.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
public class RawData {
  private String fips;
  private String admin2;
  private String provinence_state;
  private String country_region;
  private String last_update;
  private String lat;
  private String long_;
  private String confirmed;
  private String deaths;
  private String recovered;
  private String active;
  private String combined_key;
  private String incident_Rate;
  private String case_fatality_ratio;
}
