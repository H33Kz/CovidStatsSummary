package com.h33kz.CovidStatsSummary.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SummaryStats {
  private Cases global;
  private Cases china;
  private Cases nonChina;
}
