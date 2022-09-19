package com.example.dongsungsi.paging;

import lombok.Data;

/**
 * packageName : com.example.paging_backend.paging
 * fileName : Criteria
 * author : gumin
 * date : 2022-06-10
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-10         gumin          최초 생성
 */
@Data
public class Criteria {
    // 현재 페이지 번호
    // *Long(객체), long(기본형), Integer(객체), long(기본형)
    private Integer page;
    // 1페이지당 출력할 데이터 개수
    private Integer size;
    // 테이블 총 데이터 개수
    private Integer totalItems;
    // 총 페이지 수 = 계산 공식 : 테이블 총 데이터 개수(totalItems) / 1페이지당 출력할 데이터 개수(size)
    private Integer totalPages;
    // 검색 제목
    private String  title;
    // 검색 email
    private String  email;
    // 검색 ID
    private String id;

    // 기본 페이지 정보 저장
    public Criteria() {
        this.page = 0; // 현재 페이지
        this.size = 3; // 페이지당 건수 3개
    }
}
