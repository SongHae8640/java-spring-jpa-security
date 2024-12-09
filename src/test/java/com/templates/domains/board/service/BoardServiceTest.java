package com.templates.domains.board.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.templates.domains.board.controller.dto.BoardSaveRequest;
import com.templates.domains.board.domain.Board;
import com.templates.domains.member.domain.Member;
import com.templates.global.security.service.CustomUserDetailsService.CustomUserDetails;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;


    private static final Long TEST_USER_SEQ = 1L;

    @BeforeEach
    void setUp(){
        Member testMember = Member.builder()
            .loginId("testuser")
            .password("password")
            .name("Test User")
            .build();
        // Member의 seq를 설정 (실제로는 이렇게 하면 안 되지만, 테스트를 위해 임시로 사용)
        try {
            java.lang.reflect.Field seqField = Member.class.getDeclaredField("seq");
            seqField.setAccessible(true);
            seqField.set(testMember, TEST_USER_SEQ);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set test member seq", e);
        }

        CustomUserDetails userDetails = new CustomUserDetails(testMember);
        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @AfterEach
    void tearDown() {
        SecurityContextHolder.clearContext();
    }


    @Test
    void save() {
        // Given
        BoardSaveRequest request = new BoardSaveRequest("Test Title", "Test Content");

        // When
        Board board = boardService.save(request);

        // Then
        assertNotNull(board);
        assertEquals(request.title(), board.getTitle());
        assertEquals(request.content(), board.getContent());
        assertEquals(TEST_USER_SEQ, board.getCreatedMemberSeq());
        System.out.println("board = " + board);
    }
}