package com.springboot.app.restapi.controller;

import com.springboot.app.restapi.dao.CovidDao;
import com.springboot.app.restapi.model.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class CovidController {
    private final CovidDao covidDao;

    @Autowired
    public CovidController(CovidDao covidDao) {
        this.covidDao = covidDao;
    }

    // I know its hacky using the type to determine which graph it is
    @GetMapping("/covid/graph")
    public Graph getGraph(){
        return covidDao.findByType("covid");
    }

    @PostMapping("/covid/graph")
    public void addCovidGraph() {
        Graph covidGraph = new Graph();
        List<String> covidLabel = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun");
        List<Double> covidData = List.of(350.0, 300.0, 250.0, 270.0, 150.0, 200.0);
        covidGraph.setTitle("COVID-19 Cases In Cardiff");
        covidGraph.setType("covid");
        covidGraph.setLabels(covidLabel);
        covidGraph.setData(covidData);
        covidDao.save(covidGraph);
    }
}
