package com.vivabicho.api.controllers.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AnimalDTO {

    private long id;
    private String name;
    private long specieId;
    private String breed;
    private int age;
    private String gender;
    private String color;
    private String size;
    private double weight;
    private String description;
    private boolean availableForAdoption;


}
