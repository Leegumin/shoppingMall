package com.example.dongsungsi.dao;

import com.example.dongsungsi.model.Customer;
import com.example.dongsungsi.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.dongsungsi.dao
 * fileName : CustomerDao
 * author : gumin
 * date : 2022-06-03
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-03         gumin          최초 생성
 * 2022-06-07         gumin          일부 수정
 */
// @Mapper: mybatis 사용시 아래 적용하는 어노테이션
// 인터페이스 구현 => .xml에서 함
@Mapper
public interface CustomerDao {


    // id에 해당하는 값을 조회
    // *Optional : null을 방지하는 클래스
    public Optional<Customer> findById(Long id);

    // Todo : 2개 수정(findByEmailContaining, findAll), 1개 추가(selectTotalCount)
    // 제목 검색을 위한 메소드
    public List<Customer> findByEmailContaining(Criteria criteria);

    // 모든 데이터 목록 조회
    public List<Customer> findAll(Criteria criteria);

    // 제목에 따른 데이터 건수를 세는 메소드
    public int selectTotalCount(String email);

    // * 자료형 long가 붙는 메서드는 전부 실행 건수가 나타남

    // 회원 생성
    public long insertCustomer(Customer customer);

    // 회원 수정
    public long updateCustomer(Customer customer);

    // id로 회원 삭제
    public long deleteCustomer(Long id);

    // 회원 전체삭제
    public long deleteAll();
}
