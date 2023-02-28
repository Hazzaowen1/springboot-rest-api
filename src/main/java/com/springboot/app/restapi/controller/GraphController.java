package com.springboot.app.restapi.controller;

import com.springboot.app.restapi.dao.GraphDao;
import com.springboot.app.restapi.model.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class GraphController {

    private final GraphDao graphDao;


    @Autowired
    public GraphController(GraphDao graphDao) {
        this.graphDao = graphDao;
    }

    @GetMapping("/graph")
    public List<Graph> getGraphs(){
      return graphDao.findAll();
    }



}
