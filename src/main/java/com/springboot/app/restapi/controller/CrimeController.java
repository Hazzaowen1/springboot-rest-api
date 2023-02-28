package com.springboot.app.restapi.controller;

import com.springboot.app.restapi.dao.CrimeDao;
import com.springboot.app.restapi.model.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CrimeController {
    private final CrimeDao crimeDao;

    @Autowired
    public CrimeController(CrimeDao crimeDao) {
        this.crimeDao = crimeDao;
    }

    @GetMapping("/crime/graph")
    public Graph getGraph(){
        return crimeDao.findByType("crime");
    }


    @PostMapping("/crime/graph")
    public void addCrimeGraph() {
        Graph crimeGraph = new Graph();
        List<String> crimeLabel = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun");
        List<Double> crimeData = List.of(1.0, 2.0, 4.0, 10.0, 5.0, 3.0);
        crimeGraph.setTitle("Crime stats");
        crimeGraph.setType("crime");
        crimeGraph.setLabels(crimeLabel);
        crimeGraph.setData(crimeData);
        crimeDao.save(crimeGraph);
    }
}
