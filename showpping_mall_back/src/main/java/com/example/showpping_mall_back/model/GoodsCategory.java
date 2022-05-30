package com.example.showpping_mall_back.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * packageName : com.example.showpping_mall_back.model
 * fileName : GoodsCategory
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
public class GoodsCategory {
    private String cateName;
    private String cateCode;
    private String cateCoderef;
}
