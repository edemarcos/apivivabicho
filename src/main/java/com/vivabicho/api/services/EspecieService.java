package com.vivabicho.api.services;

import com.vivabicho.api.DTO.SpecieDTO;
import com.vivabicho.api.models.Species;
import com.vivabicho.api.repositories.EspecieRepository;
import com.vivabicho.api.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecieService {

    @Autowired
    EspecieRepository repository;

    public List<SpecieDTO> findAll(){
        SpecieDTO especieDTO = new SpecieDTO();
        return especieDTO.convertList(repository.findAll());
    }

    public Species findById(Long id){
        Species specie =  repository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Id not found " + id)
        );
        return specie;
    }

    public SpecieDTO save(Species specie){
        SpecieDTO specieDTO = new SpecieDTO();
        Species specieRepo = repository.save(specie);
        return specieDTO.convertToDto(specieRepo);
    }

    public SpecieDTO update(Species specie){
        SpecieDTO specieDTO = new SpecieDTO();
        Species specieUpdate = repository.findById(specie.getId()).orElseThrow(
                () -> new EntityNotFoundException("No records found for this ID!"));

        specieUpdate.setName(specie.getName());
        specieUpdate.setDescription(specie.getDescription());

        return specieDTO.convertToDto(repository.save(specieUpdate));
    }

}
