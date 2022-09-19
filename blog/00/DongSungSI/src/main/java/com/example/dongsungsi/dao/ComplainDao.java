package com.example.dongsungsi.dao;

import com.example.dongsungsi.model.Complain;
import com.example.dongsungsi.model.Complain;
import com.example.dongsungsi.model.Tutorial;
import com.example.dongsungsi.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.dongsungsi.dao
 * fileName : ComplainDao
 * author : gumin
 * date : 2022-06-14
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-14         gumin          최초 생성
 */
@Mapper
public interface ComplainDao {

    // id에 해당하는 값을 조회
    // *Optional : null을 방지하는 클래스
    public Optional<Complain> findById(Long id);

    // Todo : 2개 수정(findByEmailContaining, findAll), 1개 추가(selectTotalCount)
    // 제목 검색을 위한 메소드
    public List<Complain> findByTitleContaining(Criteria criteria);

    // 모든 데이터 목록 조회
    public List<Complain> findAll(Criteria criteria);

    // 제목에 따른 데이터 건수를 세는 메소드
    public int selectTotalCount(String email);

    // * 자료형 long가 붙는 메서드는 전부 실행 건수가 나타남

    // 회원 생성
    public long insertComplain(Complain customer);

    // 회원 수정
    public long updateComplain(Complain Complain);

    // id로 회원 삭제
    public long deleteComplain(Long id);

    // 회원 전체삭제
    public long deleteAll();
}
