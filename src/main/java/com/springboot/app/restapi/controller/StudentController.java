package com.springboot.app.restapi.controller;

import com.springboot.app.restapi.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// A simple Springboot RESTAPI which returns a JSON to the
// Every URL path has to be unique
@RestController
public class StudentController {


    // http://localhost:8080/students
    // Returns array list of JSON objects to client
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> Students = new ArrayList<>();
        Students.add(new Student("James","Owen"));
        Students.add(new Student("Sam","Owen"));
        Students.add(new Student("Paul","Owen"));
        Students.add(new Student("Karen","Dupuy"));
        return Students;
    }

    // Method using @PathVariable in a request for a student object
    // http://localhost:8080/student/harry/owen
    // URL template PathVariable
    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName) {
        return new Student(firstName, lastName);
    };

    // Build REST API to handle query parameters
    // http://localhost:8080/student?firstName=Harry&lastName=Owen
    @GetMapping("/student/query")
    public Student studentQueryParam(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName){
        return new Student (firstName,lastName);
    }
}
