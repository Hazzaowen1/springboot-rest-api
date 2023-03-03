package com.springboot.app.restapi.controller;

import com.springboot.app.restapi.dao.WarningDao;
import com.springboot.app.restapi.model.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class WarningController {
    private final WarningDao warningDao;

    @Autowired
    public WarningController(WarningDao warningDao) {
        this.warningDao = warningDao;
    }

    // I know its hacky using the type to determine which graph it is
    @GetMapping("/warning/graph")
    public Graph getGraph(){
        return warningDao.findByType("warning");
    }

    @PostMapping("/warning/graph")
    public void addWarningGraph() {
        Graph warningGraph = new Graph();
        List<String> warningLabel = List.of("Terrorism Threat", "Environmental Hazard", "Public Health Emergency", "Civil Emergency", "Transportation Disruption", "Natural Disasters");
        List<Double> warningData = List.of(5.0, 4.0, 2.0, 3.0, 5.0, 1.0);
        warningGraph.setTitle("Emergency Warning Status");
        warningGraph.setType("warning");
        warningGraph.setLabels(warningLabel);
        warningGraph.setData(warningData);
        warningDao.save(warningGraph);
    }
}
