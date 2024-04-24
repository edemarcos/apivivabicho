package com.vivabicho.api.DTO;

import com.vivabicho.api.models.Species;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class SpecieDTO {

    private Long id;
    private String name;
    private String description;

    public SpecieDTO() {
    }

    public SpecieDTO convertToDto(Species specie) {
        this.id = specie.getId();
        this.name = specie.getName();
        this.description = specie.getDescription();
        return this;
    }

    public Species convertToEspecie(SpecieDTO especieDTO) {

        Species specie = new Species();
        specie.setId(especieDTO.getId());
        specie.setName(especieDTO.getName());
        specie.setDescription(especieDTO.getDescription());
        return specie;
    }

    public List<SpecieDTO> convertList(List<Species> especieList){
        SpecieDTO especieDTO = new SpecieDTO();
        List<SpecieDTO> especieDTOList = new ArrayList<>();
        especieList.forEach(especie -> {
            especieDTOList.add(especieDTO.convertToDto(especie));
        });
        return especieDTOList;
    }
}
