package com.templates.global.security.controller;

import com.templates.global.security.controller.dto.LoginRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public void authenticateUser(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(request.toAuthentication());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @PostMapping("/logout")
    public void logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }

    @PostMapping("/check")
    public boolean checkAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }
}