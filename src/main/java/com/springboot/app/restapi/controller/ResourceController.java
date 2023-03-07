//package com.springboot.app.restapi.controller;
//
//import com.springboot.app.restapi.dao.ResourceDao;
//import com.springboot.app.restapi.model.Resource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//public class ResourceController {
//
//    private final ResourceDao resourceDao;
//
//    @Autowired
//    public ResourceController(ResourceDao resourceDao) {
//        this.resourceDao = resourceDao;
//    }
//
//    @GetMapping("/warning-resources")
//    public List<Resource> getResources(@RequestParam("type") String type){
//        return resourceDao.findByType(type);
//    }
//
//}
//
