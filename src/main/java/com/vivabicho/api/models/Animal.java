package com.vivabicho.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "species_id")
    private Species species;
    private String breed;
    private int age;
    private String gender;
    private String color;
    private String size;
    private double weight;
    private String description;
    private boolean availableForAdoption;
}
