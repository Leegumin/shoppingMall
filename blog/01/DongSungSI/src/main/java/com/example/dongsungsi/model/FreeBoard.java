package com.example.dongsungsi.model;

import lombok.Data;

/**
 * packageName : com.example.dongsungsi.model
 * fileName : FreeBoard
 * author : gumin
 * date : 2022-06-14
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-14         gumin          최초 생성
 */
@Data
public class FreeBoard {
    private Long   id; // 게시판 번호
    private String title; // 게시판 제목
    private String content; // 게시판 내용
    private String writer; // 작성자
    private String deleteYn; // 삭제여부
    private String insertTime; // 쓴날짜
    private String updateTime; // 수정날짜
    private String deleteTime; // 삭제날짜
}
