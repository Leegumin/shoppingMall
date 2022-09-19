package com.example.dongsungsi.model;

import lombok.Data;

/**
 * packageName : com.example.dongsungsi.model
 * fileName : Complain
 * author : gumin
 * date : 2022-06-14
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-14         gumin          최초 생성
 */
@Data
public class Complain {
    private Long   id; // 컴플레인 번호
    private String title; // 컴플레인 제목
    private String content; // 컴플레인 내용
    private String targetPage; // 컴플레인 위치
    private String writer; // 작성자
    private String deleteYn; // 삭제여부
    private String insertTime; // 쓴날짜
    private String updateTime; // 수정날짜
    private String deleteTime; // 삭제날짜
}
