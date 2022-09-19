package com.example.dongsungsi.service;

import com.example.dongsungsi.model.FAQBoard;
import com.example.dongsungsi.paging.Criteria;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.dongsungsi.service
 * fileName : FAQBoardService
 * author : Mingu
 * date : 2022-06-15
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-15         Mingu          최초 생성
 */
public interface FAQBoardService {

    // id로 회원 조회
    public Optional<FAQBoard> findById(Long id);

    // Todo: 2개 수정 findByTitleContaining, findAll
    // 이메일로 회원 찾기
    public List<FAQBoard> findByTitleContaining(Criteria criteria);

    // 모든 회원 조회
    public List<FAQBoard> findAll(Criteria criteria);

    // 서비스 메소드
    // *insert&update 같이 구성되는 메소드
    public Optional<FAQBoard> save(FAQBoard faqBoard);

    // id로 회원 삭제
    public boolean deleteById(Long id);

    // 모든 회원 삭제
    public boolean deleteAll();
}
