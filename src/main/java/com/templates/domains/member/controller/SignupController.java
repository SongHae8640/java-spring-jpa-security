package com.templates.domains.member.controller;


import com.templates.domains.member.controller.dto.SignupRequestDto;
import com.templates.domains.member.service.SignupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Signup", description = "회원가입 API")
public class SignupController {
    private final SignupService service;

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "회원 정보를 입력받아 가입처리를 수행합니다.")
    public void signup(@RequestBody @Valid SignupRequestDto dto) {
        service.signup(dto);
    }
}