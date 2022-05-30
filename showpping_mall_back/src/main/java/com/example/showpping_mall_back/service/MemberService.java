package com.example.showpping_mall_back.service;

import com.example.showpping_mall_back.model.Member;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.showpping_mall_back.service
 * fileName : MemberService
 * author : Mingu
 * date : 2022-05-31
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-31         Mingu          최초 생성
 */
public interface MemberService {

    // insert&update와 같이 구성되는 메소드
    // *참 거짓 값을 넘겨줌
    public boolean save(Member member);



    // 화면에서 publish 버튼을 클릭할 때 적용되는 메소드
    // * List<Tutorial> 배열을 반환
    // !List<Tutorial> findByPublished(String published);

    // 제목 검색을 위한 메소드
    // !List<Tutorial> findByTitleContaining(String title);

    // 모든 데이터 목록 조회
    // !List<Tutorial> findAll();

    // id에 해당하는 값을 조회
    // Optional : null을 방지하는 클래스
    // !Optional<Tutorial> findById(Long id);

    // Tutorial 테이블에 데이터 넣기 메소드
    // !int insertTutorial(Tutorial tutorial);

    // Tutorial 테이블에 데이터 수정 메소드
    // !int updateTutorial(Tutorial tutorial);

    // Tutorial 테이블에 데이터 삭제(수정) 메소드
    // !int deleteTutorial(Long id);

    // Tutorial 테이블에 데이터 모두삭제(수정) 메소드
    // !int deleteAll();
}
