package com.h33kz.CovidStatsSummary.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Simplesummary {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private long confirmed;
  private long deaths;
}
