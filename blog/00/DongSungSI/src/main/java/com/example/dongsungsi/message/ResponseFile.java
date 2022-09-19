package com.example.dongsungsi.message;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * packageName : com.example.dongsunguploaddb.message
 * fileName : ResponseFile
 * author : gumin
 * date : 2022-05-31
 * description : Vue에 이미지를 담아서 보낼 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-31         gumin          최초 생성
 */
@Data
// @AllArgsConstructor : 모든 매개변수를 포함하는 생성자 자동생성
// @ArgsConstructor : 기본 생성자(매개변수가 없는) 자동생성
@AllArgsConstructor
public class ResponseFile {
    // TB_FILES 테이블의 컬럼정보
    private String id; // 사진번호
    private String name; // 첨부파일 이름
    private String url; // 첨부파일 주소
    private String type; // 이미지 유형
    private long size; // 이미지 크기
}
