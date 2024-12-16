package com.templates.domains.board.controller.dto;

import jakarta.validation.constraints.*;

public record BoardQueryRequest(
   @NotBlank String keyword
) {
}