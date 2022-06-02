package com.example.dongsungsi.dao;

import com.example.dongsungsi.model.FileDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.dongsungsi.dao
 * fileName : FileDBDao
 * author : gumin
 * date : 2022-06-02
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-02         gumin          최초 생성
 */
@Mapper
public interface FileDBDao {
    FileDB findById(String id); // id로 찾는 메소드

    List<FileDB> findAll(); // 모든 이미지 목록을 찾는 메소드

    int save(FileDB fileDB); // 업로드 이미지 저장 메소드
}
