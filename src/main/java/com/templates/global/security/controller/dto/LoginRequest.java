package com.templates.global.security.controller.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public record LoginRequest(
    @NotBlank String loginId,
    @NotBlank String password
) {

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(loginId, password);
    }
}