package com.templates.domains.board.controller.dto;

import com.templates.domains.board.domain.Board;
import jakarta.validation.constraints.NotBlank;

public record BoardSaveRequest(
    @NotBlank String title,
    @NotBlank String content
) {

    public Board toEntity() {
        return Board.builder()
            .title(title)
            .content(content)
            .build();
    }
}