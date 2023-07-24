package com.h33kz.CovidStatsSummary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.h33kz.CovidStatsSummary.service.DBStatsService;

@Controller
public class GUIController {
  @Autowired
  private DBStatsService service;

  @GetMapping("/")
  public ModelAndView getHome(){
    ModelAndView mav = new ModelAndView("index");
    mav.addObject("countries", service.getAll());
    return mav;
  }
}
