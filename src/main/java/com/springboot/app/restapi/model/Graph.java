package com.springboot.app.restapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "graph")
public class Graph {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    @ElementCollection
    private List<Double> data = new ArrayList<>();

    @ElementCollection
    private List<String> labels = new ArrayList<>();
}
