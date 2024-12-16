package com.templates.domains.board.repository;

import static com.templates.domains.board.domain.QBoard.*;

import com.querydsl.core.types.dsl.*;
import com.querydsl.jpa.impl.*;
import com.templates.domains.board.controller.dto.*;
import com.templates.domains.board.domain.*;
import java.util.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Board> findByCondition(BoardQueryRequest request, PageRequest pageRequest) {
        List<Board> boards = queryFactory.selectFrom(board)
            .where(containKeyword(request.keyword()))
            .orderBy(board.createdAt.desc())
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize())
            .fetch();

        long totalCount = queryFactory.select(board.seq)
            .from(board)
            .where(containKeyword(request.keyword()))
            .fetchCount();

        return new PageImpl<>(boards, pageRequest, totalCount);
    }
    

    private static BooleanExpression containKeyword(String keyword) {
        return board.title.containsIgnoreCase(keyword)
            .or(board.content.containsIgnoreCase(keyword));
    }
}