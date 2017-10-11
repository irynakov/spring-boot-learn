package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReportController {

  @Autowired
  private ApplicationContext appContext;

  @RequestMapping(value = "/report.pdf", method = RequestMethod.GET)
  public ModelAndView getReportPdf() {


    JasperReportsPdfView view = new JasperReportsPdfView();
    view.setUrl("classpath:report.jrxml");
    view.setApplicationContext(appContext);

    Map<String, Object> params = new HashMap<>();
    params.put("ReportTitle", "Jasper Demo");
    params.put("Author", "Prepared ikr");
    params.put("datasource", ShipwreckStub.getValues());

    return new ModelAndView(view, params);
  }
}
