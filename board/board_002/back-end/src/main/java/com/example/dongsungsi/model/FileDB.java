package com.example.dongsungsi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName : com.example.dongsungsi.model
 * fileName : FileDB
 * author : gumin
 * date : 2022-06-02
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-02         gumin          최초 생성
 */
@Data
// Lombok에서 생성자를 자동으로 지원해줌
// NoArgsConstructor: 매개변수가 없는 기본 생성자를 자동으로 만들어줌
@NoArgsConstructor
public class FileDB {
    private String id; // 첨부파일 아이디
    private String name; // 첨부파일 이름
    private String type; // 첨부파일 타입(image? text? 등)
    private byte[] data; // oracle 이미지 담는 자료형(BLOB) : byte[]

    public FileDB(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
