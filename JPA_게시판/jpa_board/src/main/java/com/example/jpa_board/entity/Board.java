package com.example.jpa_board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName : com.example.jpa_board.entity
 * fileName : Board
 * author : Mingu
 * date : 2022-09-21
 * description : 데이터베이스 테이블과 직접적으로 연관되는 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-21         Mingu          최초 생성
 */
// *@Entity : 해당 클래스가 테이블과 매핑되는 JPA의 엔티티(Entity) 클래스임을 의미, 기본적으로 클래스명(Camel Case)을 테이블명(Snake Case)으로 매핑
// * ex) user_role(테이블 이름) = UserRole(클래스 이름), 클래스 명과 테이블 명이 다를 경우 @Table 사용
// *@NoArgsConstructor(access = AccessLevel.PROTECTED) : access 조건이 붙을 경우 repository의 위치가 달라짐. protected는 동일한 패키지 내의 클래스에서만 객체를 생성
@Entity
@Table(name = "jpa_board")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    // *@Id : Entity의 기본 키라는걸 알려주는 어노테이션
    // *@GeneratedValue(strategy = GenerationType.IDENTITY) : 주키의 값을 위한 자동 생성 전략을
    // *@Column : Entity의 컬럼 값이라는걸 알려주는 어노테이션

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id; // pk값
    @Column
    private String title; // 제목
    @Column
    private String content; // 내용
    @Column
    private String writer; // 작성자
    @Column
    private int    hits; // 조회수
    @Column
    private char   deleteYn = 'N'; // 삭제여부
    @Column
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // 글쓴 날짜
    @Column
    private String modifiedDate; // 글 수정한 날짜

    // BoardDto에서 데이터를 받아오기 위한 생성자
    // *@Builder : 생성자를 대신하는 Builder
    public Board(Long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
