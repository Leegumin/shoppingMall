package com.example.dongsungsi.service;

import com.example.dongsungsi.model.Complain;
import com.example.dongsungsi.model.Complain;
import com.example.dongsungsi.paging.Criteria;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.dongsungsi.service
 * fileName : ComplainService
 * author : gumin
 * date : 2022-06-14
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-14         gumin          최초 생성
 */
public interface ComplainService {
    // id로 회원 조회
    public Optional<Complain> findById(Long id);

    // Todo: 2개 수정 findByTitleContaining, findAll
    // 이메일로 회원 찾기
    public List<Complain> findByTitleContaining(Criteria criteria);

    // 모든 회원 조회
    public List<Complain> findAll(Criteria criteria);

    // 서비스 메소드
    // *insert&update 같이 구성되는 메소드
    public Optional<Complain> save(Complain complain);

    // id로 회원 삭제
    public boolean deleteById(Long id);

    // 모든 회원 삭제
    public boolean deleteAll();
}
