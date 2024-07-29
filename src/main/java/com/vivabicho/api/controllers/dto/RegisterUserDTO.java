package com.vivabicho.api.controllers.dto;

import com.vivabicho.api.models.Role;

public record RegisterUserDTO(String login, String password, Role role) {
}
