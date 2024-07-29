package com.vivabicho.api.controllers;

import com.vivabicho.api.controllers.dto.SpecieDTO;
import com.vivabicho.api.services.EspecieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/species")
public class EspecieController {

    @Autowired
    private EspecieService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpecieDTO> save(@RequestBody @Valid SpecieDTO specieDTO){
        return ResponseEntity.ok(service.save(specieDTO.convertToEspecie(specieDTO)));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpecieDTO> update(@RequestBody @Valid SpecieDTO especieDTO){
        return ResponseEntity.ok(service.update(especieDTO.convertToEspecie(especieDTO)));
    }
}
