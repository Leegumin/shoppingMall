package com.example.dongsungsi.service;

import com.example.dongsungsi.model.Tutorial;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.dongsungsi.service
 * fileName : TutorialService
 * author : gumin
 * date : 2022-05-25
 * description : DAO, Model 이용해서 업무로직을 구성하는 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-25         gumin          최초 생성
 */
public interface TutorialService {

    // 자료검색 (select) 메소드
    public Optional<Tutorial> findById(Long id);

    public List<Tutorial> findByPublished(String published);

    public List<Tutorial> findByTitleContaining(String title);

    public List<Tutorial> findAll();

    // 서비스 메소드
    // *insert&update와 같이 구성되는 메소드
    // *참 거짓 값을 넘겨줌
    public boolean save(Tutorial tutorial);

    public boolean deleteById(Long id);

    public boolean deleteAll();
}
