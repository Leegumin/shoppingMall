--유저생성
CREATE USER GUMIN --유저명
IDENTIFIED BY 1234 --비밀번호
DEFAULT TABLESPACE USERS --기본 테이블 스페이스
TEMPORARY TABLESPACE TEMP; --임시 테이블 스페이스

--계정 권한 부여
GRANT CONNECT TO GUMIN; --데이터베이스 접속 관련 권한
GRANT RESOURCE TO GUMIN; --테이블, 시퀀스 등 데이터 관련 객체 생성 권한
GRANT DBA TO GUMIN; -- 시스템 자원의 무제한 사용, 다른 사용자 권한 조정 등이 가능한 권한

-- 유저만들기
-- CMD, 혹은 관리자계정에서 실행
--* USER 생성에 대한 권한 부여
--grant create user to scott;
-- SCOTT 유저 권한상승 : 롤(ROLE : 여러 권한들을 모두 모아놓은 것)
-- CONNECT(접속에 관련된 권한 모음집)
-- RESOURCE(테이블, 뷰, 프로시저 생성 권한 모음집)
-- DBA(유저, DB관리 등등 최상위 권한 모음집)

-- 권한 종류
-- CREATE TABLE : 테이블 생성 권한
-- CREATE VIEW : 뷰 생성 권한
-- CREATE SEQUENCE : 시퀀스 생성 권한

-- 권한부여 명령어
-- GRANT 권한(롤) TO 유저명

-- 권한취소 명령어
-- REVOKE 권한(롤) FROM 유저명

-- 동의어 : 테이블 : SELECT * FROM SCOTT3.EMPLOYEE
--                  별칭으로 변경해서 이름을 정의해줄 수 있음
-- 허나 관리자만 가능해서 개발자는 몰?루 해도 됨