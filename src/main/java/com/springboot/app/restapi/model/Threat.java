package com.springboot.app.restapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "threat")
public class Threat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String type;
    private String level;
    private String colour;
    private String description;

}
