package com.h33kz.CovidStatsSummary.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Meta {
  private String lastUpdated;
  private String expires;
  private long lastUpdatedTimestamp;
  private long expiresTimestamp;
}
