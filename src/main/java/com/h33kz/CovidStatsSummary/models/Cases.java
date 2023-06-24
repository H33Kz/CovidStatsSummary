package com.h33kz.CovidStatsSummary.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Cases {
  private int confirmed;
  private int recovered;
  private int deaths;
}
