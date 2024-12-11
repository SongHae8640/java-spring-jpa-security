package com.templates.domains.board.controller;

import com.templates.domains.board.controller.dto.*;
import com.templates.domains.board.domain.*;
import com.templates.domains.board.repository.*;
import com.templates.domains.board.service.*;
import com.templates.global.dto.*;
import io.swagger.v3.oas.annotations.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.validation.annotation.*;
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
    public Page<Board> findAll(
        @Parameter(name = "CustomPageRequest")
        @Validated CustomPageRequest request) {
        return repository.findAll(request.toPageRequest());
    }
}