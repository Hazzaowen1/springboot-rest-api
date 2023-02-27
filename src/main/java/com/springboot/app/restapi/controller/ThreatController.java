package com.springboot.app.restapi.controller;

import com.springboot.app.restapi.dao.ThreatDao;
import com.springboot.app.restapi.model.Threat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ThreatController {

    private final ThreatDao threatDao;

    @Autowired
    public ThreatController(ThreatDao threatDao) {
        this.threatDao = threatDao;
    }

    @GetMapping("/threats")
    public List<Threat> getThreats() {
        return threatDao.findAll();
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
