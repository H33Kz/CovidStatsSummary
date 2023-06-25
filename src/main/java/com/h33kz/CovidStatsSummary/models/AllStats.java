package com.h33kz.CovidStatsSummary.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class AllStats {
  private SummaryStats summaryStats;
  private Meta cache;
  private DataSource dataSource;
  private String apiSourceCode;
  private ArrayList<RawData> rawData;
}
