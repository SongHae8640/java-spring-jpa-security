package com.templates.domains.board.controller.dto;

import com.templates.domains.board.domain.Board;

public record BoardSaveRequest(
    String title,
    String content
) {

    public Board toEntity() {
        return Board.builder()
            .title(title)
            .content(content)
            .build();
    }
}