package com.vivabicho.api.mappers;

import com.vivabicho.api.DTO.AnimalDTO;
import com.vivabicho.api.models.Animal;
import com.vivabicho.api.models.Species;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalMapper {

    public AnimalDTO mapperToAnimalDTO(Animal animal) {
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setId(animal.getId());
        animalDTO.setName(animal.getName());
        animalDTO.setSpecieId(animal.getSpecies().getId());
        animalDTO.setBreed(animal.getBreed());
        animalDTO.setAge(animal.getAge());
        animalDTO.setGender(animal.getGender());
        animalDTO.setColor(animal.getColor());
        animalDTO.setSize(animal.getSize());
        animalDTO.setWeight(animal.getWeight());
        animalDTO.setDescription(animal.getDescription());
        animalDTO.setAvailableForAdoption(animal.isAvailableForAdoption());
        return animalDTO;
    }

    public Animal mapperToAnimal(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setId(animalDTO.getId());
        animal.setName(animalDTO.getName());
        Species specie = new Species();
        specie.setId(animalDTO.getSpecieId());
        animal.setSpecies(specie);
        animal.setBreed(animalDTO.getBreed());
        animal.setAge(animalDTO.getAge());
        animal.setGender(animalDTO.getGender());
        animal.setColor(animalDTO.getColor());
        animal.setSize(animalDTO.getSize());
        animal.setWeight(animalDTO.getWeight());
        animal.setDescription(animalDTO.getDescription());
        animal.setAvailableForAdoption(animalDTO.isAvailableForAdoption());
        return animal;
    }

    public List<AnimalDTO> convertList(List<Animal> animalList){
        List<AnimalDTO> animalDTOList = new ArrayList<>();
        animalList.forEach(animal -> {
            animalDTOList.add(this.mapperToAnimalDTO(animal));
        });
        return animalDTOList;
    }
}
