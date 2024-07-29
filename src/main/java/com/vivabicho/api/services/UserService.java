package com.vivabicho.api.services;

import com.vivabicho.api.controllers.dto.ResponseUserDTO;
import com.vivabicho.api.models.User;
import com.vivabicho.api.repositories.UserRespository;
import com.vivabicho.api.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRespository repository;

    public List<ResponseUserDTO> findAll(){
        ResponseUserDTO responseUserDTO = new ResponseUserDTO();
        return responseUserDTO.convertList(repository.findAll());
    }

    public ResponseUserDTO findById(Long id){
        User user =  repository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Id not found " + id)
        );
        ResponseUserDTO responseUserDTO = new ResponseUserDTO();
        return responseUserDTO.convert(user);
    }

    public ResponseUserDTO save(User user){
        UserDetails userExist = repository.findByLogin(user.getUsername());
        if(userExist != null){
            throw new RuntimeException("User already exists!");
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        ResponseUserDTO responseUserDTO = new ResponseUserDTO();
        User userRepo = repository.save(user);
        return responseUserDTO.convert(userRepo);
    }

    public ResponseUserDTO update(User user){
        ResponseUserDTO responseUserDTO = new ResponseUserDTO();
        User userUpdate = repository.findById(user.getId()).orElseThrow(
                () -> new EntityNotFoundException("No records found for this ID!"));

        userUpdate.setLogin(user.getUsername());
        userUpdate.setPassword(user.getPassword());

        return responseUserDTO.convert(repository.save(userUpdate));
    }

    public void delete(Long id){
        var entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
