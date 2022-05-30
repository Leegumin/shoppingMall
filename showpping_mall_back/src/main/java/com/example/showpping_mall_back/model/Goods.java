package com.example.showpping_mall_back.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * packageName : com.example.showpping_mall_back.model
 * fileName : Goods
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
public class Goods {
    private Long          gdsNum;
    private String        gdsName;
    private String        cateCode;
    private Long          gdsPrice;
    private Long          gdsStock;
    private String        gdsDes;
    private String        gdsImg;
    private LocalDateTime gdsDate;
}
