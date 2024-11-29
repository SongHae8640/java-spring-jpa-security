package com.templates.domains.member.controller.dto;

import com.templates.domains.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.password.PasswordEncoder;

public record SignupRequestDto(
    @NotBlank String loginId,
    @NotBlank String password,
    @NotBlank String name
) {

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .loginId(loginId)
                .password(passwordEncoder.encode(password))
                .name(name)
                .build();
    }
}