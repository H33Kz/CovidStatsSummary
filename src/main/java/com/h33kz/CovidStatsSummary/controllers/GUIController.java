package com.h33kz.CovidStatsSummary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GUIController {
  @GetMapping("/")
  public String getHome(){
    return "test";
  }
  
}
