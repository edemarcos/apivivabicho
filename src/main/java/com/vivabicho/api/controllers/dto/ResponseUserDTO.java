package com.vivabicho.api.controllers.dto;

import com.vivabicho.api.models.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseUserDTO {

    private String login;
    private String email;

    public ResponseUserDTO convert(User user) {
        BeanUtils.copyProperties(user, this, "id", "password", "admin");
        return this;
    }

    public List<ResponseUserDTO> convertList(List<User> userList){
        ResponseUserDTO responseUserDTO = new ResponseUserDTO();
        List<ResponseUserDTO> responseUserDTOList = new ArrayList<>();
        userList.forEach(user -> {
            responseUserDTOList.add(responseUserDTO.convert(user));
        });
        return responseUserDTOList;
    }
}
