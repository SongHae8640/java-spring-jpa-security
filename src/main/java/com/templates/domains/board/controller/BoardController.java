package com.templates.domains.board.controller;

import com.templates.domains.board.controller.dto.BoardSaveRequest;
import com.templates.domains.board.domain.Board;
import com.templates.domains.board.repository.BoardRepository;
import com.templates.domains.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;
    private final BoardRepository repository;

    @PostMapping
    public Board create(@RequestBody @Validated BoardSaveRequest request) {
        return service.save(request);
    }

    @GetMapping
    public Page<Board> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}