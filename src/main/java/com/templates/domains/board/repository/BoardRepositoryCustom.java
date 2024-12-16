package com.templates.domains.board.repository;

import com.templates.domains.board.controller.dto.*;
import com.templates.domains.board.domain.*;
import org.springframework.data.domain.*;

public interface BoardRepositoryCustom {
    Page<Board> findByCondition(BoardQueryRequest request, PageRequest pageRequest);
}