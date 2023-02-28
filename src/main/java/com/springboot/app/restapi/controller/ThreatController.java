package com.springboot.app.restapi.controller;

import com.springboot.app.restapi.dao.ThreatDao;
import com.springboot.app.restapi.model.Threat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ThreatController {

    private final ThreatDao threatDao;

    @Autowired
    public ThreatController(ThreatDao threatDao) {
        this.threatDao = threatDao;
    }

    @GetMapping("/threats")
    public List<Threat> getAllThreats() {
        return threatDao.findAll();
    }

    public Threat createThreat(String colour, String level, String type, String description){
        Threat threat = new Threat();
        threat.setColour(colour);
        threat.setLevel(level);
        threat.setType(type);
        threat.setDescription(description);
        return threat;
    }

    @PostMapping("/threats")
    public void addThreats(){
        List<Threat> threats = new ArrayList<>();
        threats.add(createThreat("status-red", "High", "terror", "High chance of terror"));
        threats.add(createThreat("status-green", "Low", "terror", "Low chance of terror"));
        threats.add(createThreat("status-red", "High", "weather", "High chance of dangerous weather"));
        threats.add(createThreat("status-green", "Low", "weather", "Low chance of dangerous weather"));
        threatDao.saveAll(threats);
    }


    @GetMapping("/threats/query")
    public List<Threat> getFilteredThreats(@RequestParam("type") String type, @RequestParam("level") String level) {
        List<Threat> threats = threatDao.findAll();
        return threats.stream()
                .filter(threat -> threat.getType().equals(type) && threat.getLevel().equals(level))
                .collect(Collectors.toList());
    }

    @GetMapping("/threats/{id}")
    public Threat getThreat(@PathVariable Long id){
        Optional<Threat> threatById = threatDao.findById(id);
        if(threatById.isPresent()){
            return threatById.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Threat with id " + id + "not found" );
        }
    }
}
