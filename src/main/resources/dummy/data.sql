INSERT INTO tb_member (login_id, password, name, status, created_at, updated_at)
VALUES ('string', '$2a$10$YYCgKcbHhcryQI8CMYIBkeksrwI66y9Oa3KqHzzKQgMhQAG5yDSJC', '조조', 'ACTIVE', now(), now());
INSERT INTO tb_member (login_id, password, name, status, created_at, updated_at)
VALUES ('str', '$2a$10$YYCgKcbHhcryQI8CMYIBkeksrwI66y9Oa3KqHzzKQgMhQAG5yDSJC', '유비', 'ACTIVE', now(), now());
INSERT INTO tb_member (login_id, password, name, status, created_at, updated_at)
VALUES ('hihi', '$2a$10$YYCgKcbHhcryQI8CMYIBkeksrwI66y9Oa3KqHzzKQgMhQAG5yDSJC', '손권', 'ACTIVE', now(), now());
INSERT INTO tb_member (login_id, password, name, status, created_at, updated_at)
VALUES ('abc', '$2a$10$YYCgKcbHhcryQI8CMYIBkeksrwI66y9Oa3KqHzzKQgMhQAG5yDSJC', '제갈량', 'ACTIVE', now(), now());
INSERT INTO tb_member (login_id, password, name, status, created_at, updated_at)
VALUES ('qwer', '$2a$10$YYCgKcbHhcryQI8CMYIBkeksrwI66y9Oa3KqHzzKQgMhQAG5yDSJC', '항우', 'ACTIVE', now(), now());


INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('오늘의 날씨는 맑음입니다. 외출하기 좋은 날이에요!', '2024-12-11 08:21:27.956515', 1, '오늘의 날씨', '2024-12-11 08:21:27.956515', 1, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('새로운 프로젝트 시작! 팀원 모집 중입니다.', '2024-12-11 09:15:30.123456', 2, '프로젝트 팀원 모집', '2024-12-11 09:15:30.123456', 2, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('주말에 등산 가실 분 계신가요? 함께 가요!', '2024-12-11 10:30:45.234567', 3, '주말 등산 모임', '2024-12-11 10:30:45.234567', 3, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('새로 나온 영화 리뷰입니다. 꼭 보세요!', '2024-12-11 11:45:50.345678', 4, '최신 영화 리뷰', '2024-12-11 11:45:50.345678', 4, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('맛집 추천합니다. 이번 주말에 가봐요!', '2024-12-11 13:00:10.456789', 5, '맛집 추천', '2024-12-11 13:00:10.456789', 5, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('코딩 스터디 모집합니다. 함께 공부해요!', '2024-12-11 14:20:25.567890', 1, '코딩 스터디 모집', '2024-12-11 14:20:25.567890', 1, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('새 책 읽고 있어요. 독서 모임 하실 분?', '2024-12-11 15:35:40.678901', 2, '독서 모임', '2024-12-11 15:35:40.678901', 2, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('헬스장 회원권 양도합니다. 관심 있으신 분?', '2024-12-11 16:50:55.789012', 3, '헬스장 회원권 양도', '2024-12-11 16:50:55.789012', 3, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('주식 투자 조언 나눠요. 함께 성장해요!', '2024-12-11 18:10:15.890123', 4, '주식 투자 조언', '2024-12-11 18:10:15.890123', 4, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('여행 계획 중입니다. 추천 장소 있나요?', '2024-12-11 19:25:30.901234', 5, '여행 추천', '2024-12-11 19:25:30.901234', 5, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('새로운 취미 시작했어요. 경험 공유해요!', '2024-12-11 20:40:45.012345', 1, '새 취미 공유', '2024-12-11 20:40:45.012345', 1, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('집에서 할 수 있는 운동 추천해주세요.', '2024-12-11 21:55:00.123456', 2, '홈트레이닝 추천', '2024-12-11 21:55:00.123456', 2, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('요리 레시피 공유합니다. 맛있게 만들어보세요!', '2024-12-11 23:10:15.234567', 3, '요리 레시피 공유', '2024-12-11 23:10:15.234567', 3, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('반려동물 돌봄 팁 나눠요. 함께 공부해요!', '2024-12-12 00:25:30.345678', 4, '반려동물 돌봄 팁', '2024-12-12 00:25:30.345678', 4, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('중고 자전거 팝니다. 상태 좋아요!', '2024-12-12 01:40:45.456789', 5, '중고 자전거 판매', '2024-12-12 01:40:45.456789', 5, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('주말에 봉사활동 갑니다. 함께 하실 분?', '2024-12-12 02:55:00.567890', 1, '봉사활동 모집', '2024-12-12 02:55:00.567890', 1, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('외국어 회화 스터디 모집합니다. 함께 배워요!', '2024-12-12 04:10:15.678901', 2, '외국어 스터디', '2024-12-12 04:10:15.678901', 2, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('집 인테리어 팁 공유해요. 아이디어 주세요!', '2024-12-12 05:25:30.789012', 3, '인테리어 팁', '2024-12-12 05:25:30.789012', 3, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('지역 축제 정보 공유합니다. 함께 즐겨요!', '2024-12-12 06:40:45.890123', 4, '지역 축제 정보', '2024-12-12 06:40:45.890123', 4, DEFAULT);
INSERT INTO board (content, created_at, created_member_seq, title, updated_at, updated_member_seq, seq) 
VALUES ('동네 맛집 리스트 만들어요. 추천 부탁드려요!', '2024-12-12 07:55:00.901234', 5, '동네 맛집 리스트', '2024-12-12 07:55:00.901234', 5, DEFAULT);