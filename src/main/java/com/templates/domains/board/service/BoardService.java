package com.templates.domains.board.service;

import com.templates.domains.board.controller.dto.BoardSaveRequest;
import com.templates.domains.board.domain.Board;
import com.templates.domains.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;

    @Transactional
    public Board save(BoardSaveRequest request) {
        return repository.save(request.toEntity());
    }
}