package com.example.jpa_board.dto;

import com.example.jpa_board.entity.Board;
import lombok.Data;

/**
 * packageName : com.example.jpa_board.dto
 * fileName : BoardDto
 * author : Mingu
 * date : 2022-09-21
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-21         Mingu          최초 생성
 */
@Data
public class BoardDto {
    private Long   id;
    private String title;
    private String content;
    private String writer;



    // toEntity : 데이터 저장 작업을 수행하기 위해 toEntity로 보내는 메서드
    public Board toEntity() {
        return new Board(id, title, content, writer);
    }
}
