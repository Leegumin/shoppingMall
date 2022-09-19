package com.example.dongsungsi.model;

import lombok.Data;

/**
 * packageName : com.example.dongsungsi.model
 * fileName : FAQBoard
 * author : Mingu
 * date : 2022-06-15
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-15         Mingu          최초 생성
 */
@Data
public class FAQBoard {
    private Long   id; // 게시판 번호
    private String title; // 게시판 제목
    private String content; // 게시판 내용
    private String deleteYn; // 삭제여부
    private String insertTime; // 쓴날짜
    private String updateTime; // 수정날짜
    private String deleteTime; // 삭제날짜
}
