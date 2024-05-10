package com.vivabicho.api.controllers;

import com.vivabicho.api.dto.RegisterUserDTO;
import com.vivabicho.api.dto.ResponseUserDTO;
import com.vivabicho.api.models.User;
import com.vivabicho.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUserDTO> findById(@PathVariable Long id){
        ResponseUserDTO responseUserDTO =  service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseUserDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResponseUserDTO>> findAll(){
        List<ResponseUserDTO> responseUserDTOList = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(responseUserDTOList);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUserDTO> save(@RequestBody @Valid RegisterUserDTO userRequest) {
        var user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
