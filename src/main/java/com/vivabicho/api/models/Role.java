package com.vivabicho.api.models;

import jakarta.persistence.*;
import lombok.Data;

public enum Role {

    ADMIN("admin"),
    USER("user");

    private String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
