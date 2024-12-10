package com.templates.domains.board.controller;

import com.templates.domains.board.controller.dto.BoardSaveRequest;
import com.templates.domains.board.domain.Board;
import com.templates.domains.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @PostMapping
    public Board create(@RequestBody @Validated BoardSaveRequest request) {
        return service.save(request);
    }
}