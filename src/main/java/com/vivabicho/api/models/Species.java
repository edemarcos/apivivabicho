package com.vivabicho.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "species", fetch = FetchType.LAZY)
    private List<Animal> animals;

    @Override
    public String toString() {
        return "Species{id=" + id + ", name='" + name + "', description='" + description + "'}";
    }
}
