package com.example.dongsungsi.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * packageName : com.example.dongsungsi.model
 * fileName : Customer
 * author : gumin
 * date : 2022-06-03
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-03         gumin          최초 생성
 * 2022-06-07         gumin          일부수정
 */
@Data
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Customer {
    // *Long(객체자료형), long(일반자료형)
    private Long   id; // 회원 아이디
    private String firstName; // 회원 이름   
    private String lastName; // 회원 성    
    private String email; // email       
    private String phone; // 핸드폰 번호       
    private String deleteYn; // 삭제여부    
    private String insertTime; // 회원가입 날짜  
    private String updateTime; // 회원수정 날짜
    private String deleteTime; // 회원삭제 날짜
}
