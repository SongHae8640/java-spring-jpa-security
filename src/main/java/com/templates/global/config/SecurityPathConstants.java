package com.templates.global.config;

public class SecurityPathConstants {

  public static final String[] AUTH_PATHS = {"/api/v1/signup", "/api/v1/auth/login",
      "/api/v1/auth/logout"};
  public static final String[] SWAGGER_PATHS = {"/swagger-ui/**", "/v3/api-docs/**"};
  public static final String[] NO_AUTH_PATHS = {"/api/v1/boards"};
}