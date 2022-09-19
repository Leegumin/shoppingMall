package com.example.dongsungsi.dao;

import com.example.dongsungsi.model.FAQBoard;
import com.example.dongsungsi.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.dongsungsi.dao
 * fileName : FAQBoardDao
 * author : Mingu
 * date : 2022-06-15
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-15         Mingu          최초 생성
 */
@Mapper
public interface FAQBoardDao {
    // id에 해당하는 값을 조회
    // *Optional : null을 방지하는 클래스
    public Optional<FAQBoard> findById(Long id);

    // Todo : 2개 수정(findByTitleContaining, findAll), 1개 추가(selectTotalCount)
    // 제목 검색을 위한 메소드
    public List<FAQBoard> findByTitleContaining(Criteria criteria);

    // 모든 데이터 목록 조회
    public List<FAQBoard> findAll(Criteria criteria);

    // 제목에 따른 데이터 건수를 세는 메소드
    public int selectTotalCount(String title);

    // * 자료형 long가 붙는 메서드는 전부 실행 건수가 나타남

    // 회원 생성
    public long insertFAQBoard(FAQBoard faqBoard);

    // 회원 수정
    public long updateFAQBoard(FAQBoard faqBoard);

    // id로 회원 삭제
    public long deleteFAQBoard(Long id);

    // 회원 전체삭제
    public long deleteAll();
}
