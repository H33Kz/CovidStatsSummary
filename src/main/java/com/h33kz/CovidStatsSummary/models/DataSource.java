package com.h33kz.CovidStatsSummary.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DataSource {
  private String url;
  private String lastGithubCommit;
  private String publishedBy;
  private String ref;
}
