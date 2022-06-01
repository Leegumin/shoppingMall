package com.example.showpping_mall_back.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * packageName : com.example.showpping_mall_back.model
 * fileName : Member
 * author : Mingu
 * date : 2022-05-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-30         Mingu          최초 생성
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Member {
    private String        userId;
    private String        userPassword;
    private String        userName;
    private String        userPhon;
    private String        userAddr1;
    private String        userAddr2;
    private String        userAddr3;
    private LocalDateTime regiDate;
    private Long          verify;
}
