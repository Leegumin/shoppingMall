package com.example.dongsungsi.service;

import com.example.dongsungsi.dao.FAQBoardDao;
import com.example.dongsungsi.model.FAQBoard;
import com.example.dongsungsi.paging.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.dongsungsi.service
 * fileName : FAQBoardServiceImp
 * author : Mingu
 * date : 2022-06-15
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-15         Mingu          최초 생성
 */
@Service
public class FAQBoardServiceImp implements FAQBoardService{
    @Autowired
    private FAQBoardDao faqBoardDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // 회원 id로 조회하는 메서드
    @Override
    public Optional<FAQBoard> findById(Long id) {
        return faqBoardDao.findById(id);
    }

    // Todo: 2개 수정 findByTitleContaining, findAll
    @Override
    public List<FAQBoard> findByTitleContaining(Criteria criteria) {
        // *빈 값으로 초기화
        List<FAQBoard> faqBoards = Collections.emptyList();

        // Optional.ofNullable(criteria.getTitle()) : Null 체크
        Optional<String> optionalCriteria = Optional.ofNullable(criteria.getTitle());
        // optionalCriteria.orElse("") : Title 값이 Null이면 => ""으로 변경
        // 테이블의 총 건수
        int totalCount = faqBoardDao.selectTotalCount(optionalCriteria.orElse(""));

        // criteria : 페이징 처리 클래스 객체
        criteria.setTotalItems(totalCount);
        // 총 페이지 개수 : 테이블의 총 건수(totalCount) / 페이지당 출력할 데이터 개수(size)
        criteria.setTotalPages(totalCount / criteria.getSize());

        // title이 null이면 전체검색
        if (criteria.getTitle() == null) {
            faqBoards = faqBoardDao.findAll(criteria);
        }
        // title이 있으면 title 검색
        else {
            faqBoards = faqBoardDao.findByTitleContaining(criteria);
        }
        return faqBoards;
    }

    // 모든 회원 조회
    @Override
    public List<FAQBoard> findAll(Criteria criteria) {
        return faqBoardDao.findAll(criteria);
    }

    // 회원 생성&수정 서비스
    @Override
    public Optional<FAQBoard> save(FAQBoard faqBoard) {
        // db 시퀀스 번호 저장을 위한 변수
        long seqId = 0;

        // 매개변수 faqBoard 제대로 들어왔는지 확인
        logger.info("faqBoard : {} ", faqBoard);

        // faqBoard.getId() 없으면 insert문 호출
        //                  있으면 update문 호출
        if (faqBoard.getId() == null) {
            faqBoardDao.insertFAQBoard(faqBoard);
        }
        else {
            faqBoardDao.updateFAQBoard(faqBoard);
        }

        // insert문 후에는 faqBoard의 id 속성에 값이 저장됨(xml의 <selectkey>가 작동)
        seqId = faqBoard.getId();
        logger.info("faqBoard.getID - seqId : {}", seqId);

        return faqBoardDao.findById(seqId);
    }

    // id로 회원 삭제
    @Override
    public boolean deleteById(Long id) {
        long queryResult = 0;

        // faqBoardDao.deleteFAQBoard(id)가 실행되면 실행된 건수가 저장됨
        queryResult = faqBoardDao.deleteFAQBoard(id);

        // queryResult에 건수가 정상저장되면 true값을 반환
        return queryResult >= 1;
    }

    // 회원 전부 삭제
    @Override
    public boolean deleteAll() {
        long queryResult = 0;

        // faqBoardDao.deleteAll가 실행되면 실행된 건수가 저장됨
        queryResult = faqBoardDao.deleteAll();

        // queryResult에 건수가 정상저장되면 true값을 반환
        return queryResult >= 1;
    }
}
