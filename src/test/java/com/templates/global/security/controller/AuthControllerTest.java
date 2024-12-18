package com.templates.global.security.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.templates.global.security.controller.dto.LoginRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private ObjectMapper objectMapper;

  private MockHttpSession session;

  @BeforeEach
  void setup() {
    mockMvc = MockMvcBuilders
        .webAppContextSetup(context)
        .apply(springSecurity())
        .build();
    session = new MockHttpSession();
  }

  @Nested
  @DisplayName("정상 로그인 플로우 테스트")
  class SuccessfulLoginFlow {

    @Test
    @DisplayName("로그인 성공 후 인증 체크 테스트")
    void loginAndCheckAuthentication() throws Exception {
      // Given
      LoginRequest loginRequest = new LoginRequest("string", "string");

      // When: 로그인 수행
      mockMvc.perform(post("/api/v1/auth/login")
              .session(session)
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(loginRequest)))
          .andExpect(status().isOk())
          .andReturn();

      // Then: 인증 체크
      mockMvc.perform(post("/api/v1/auth/check")
              .session(session))
          .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인 후 로그아웃 및 인증 체크 테스트")
    void loginLogoutAndCheckAuthentication() throws Exception {
      // Given
      LoginRequest loginRequest = new LoginRequest("string", "string");

      // When: 로그인 수행
      mockMvc.perform(post("/api/v1/auth/login")
              .session(session)
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(loginRequest)))
          .andExpect(status().isOk());

      // Then: 로그아웃 수행
      mockMvc.perform(post("/api/v1/auth/logout")
              .session(session))
          .andExpect(status().isOk());

      // And: 인증 체크 - 로그아웃 상태 확인
      mockMvc.perform(post("/api/v1/auth/check")
              .session(session))
          .andExpect(status().isUnauthorized());
    }
  }

  @Nested
  @DisplayName("비정상 로그인 플로우 테스트")
  class FailedLoginFlow {

    @Test
    @DisplayName("잘못된 계정으로 로그인 시도 후 인증 체크 테스트")
    void loginWithWrongCredentialsAndCheckAuthentication() throws Exception {
      // Given
      LoginRequest loginRequest = new LoginRequest("wrongUser", "wrongPassword");

      // When: 잘못된 계정으로 로그인 시도
      mockMvc.perform(post("/api/v1/auth/login")
              .session(session)
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(loginRequest)))
          .andExpect(status().isUnauthorized());

      // Then: 인증 체크 - 인증되지 않은 상태 확인
      mockMvc.perform(post("/api/v1/auth/check")
              .session(session))
          .andExpect(status().isUnauthorized());
    }
  }
}