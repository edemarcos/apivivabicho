package com.vivabicho.api.dto;

import com.vivabicho.api.models.Role;

public record RegisterUserDTO(String login, String password, Role role) {
}
