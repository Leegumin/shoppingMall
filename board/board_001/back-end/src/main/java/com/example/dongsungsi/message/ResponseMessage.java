package com.example.dongsungsi.message;

import lombok.Data;

/**
 * packageName : com.example.dongsunguploaddb.message
 * fileName : ResponseMessage
 * author : gumin
 * date : 2022-05-31
 * description : Vue로 응답 메세지를 담을 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-31         gumin          최초 생성
 */
@Data
public class ResponseMessage {
    // 메세지를 담을 변수
    private String message;
    public ResponseMessage(String message) {
        this.message = message;
    }

}
