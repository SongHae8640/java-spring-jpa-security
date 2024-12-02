package com.templates.global.security.controller.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public record LoginRequest(
    String loginId,
    String password
) {

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(loginId, password);
    }
}