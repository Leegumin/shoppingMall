package com.example.dongsungsi.service;

import com.example.dongsungsi.dao.ComplainDao;
import com.example.dongsungsi.model.Complain;
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
 * fileName : ComplainServiceImp
 * author : gumin
 * date : 2022-06-14
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-14         gumin          최초 생성
 */
@Service
public class ComplainServiceImp implements ComplainService {
    @Autowired
    private ComplainDao complainDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // 회원 id로 조회하는 메서드
    @Override
    public Optional<Complain> findById(Long id) {
        return complainDao.findById(id);
    }

    // Todo: 2개 수정 findByEmailContaining, findAll
    @Override
    public List<Complain> findByTitleContaining(Criteria criteria) {
        // *빈 값으로 초기화
        List<Complain> complains = Collections.emptyList();

        // Optional.ofNullable(criteria.getTitle()) : Null 체크
        Optional<String> optionalCriteria = Optional.ofNullable(criteria.getTitle());
        // optionalCriteria.orElse("") : Title 값이 Null이면 => ""으로 변경
        // 테이블의 총 건수
        int totalCount = complainDao.selectTotalCount(optionalCriteria.orElse(""));

        // criteria : 페이징 처리 클래스 객체
        criteria.setTotalItems(totalCount);
        // 총 페이지 개수 : 테이블의 총 건수(totalCount) / 페이지당 출력할 데이터 개수(size)
        criteria.setTotalPages(totalCount / criteria.getSize());

        // email이 null이면 전체검색
        if (criteria.getTitle() == null) {
            complains = complainDao.findAll(criteria);
        }
        // email이 있으면 email 검색
        else {
            complains = complainDao.findByTitleContaining(criteria);
        }
        return complains;
    }

    // 모든 회원 조회
    @Override
    public List<Complain> findAll(Criteria criteria) {
        return complainDao.findAll(criteria);
    }

    // 회원 생성&수정 서비스
    @Override
    public Optional<Complain> save(Complain complain) {
        // db 시퀀스 번호 저장을 위한 변수
        long seqId = 0;

        // 매개변수 complain 제대로 들어왔는지 확인
        logger.info("complain : {} ", complain);

        // complain.getId() 없으면 insert문 호출
        //                  있으면 update문 호출
        if (complain.getId() == null) {
            complainDao.insertComplain(complain);
        }
        else {
            complainDao.updateComplain(complain);
        }

        // insert문 후에는 complain의 id 속성에 값이 저장됨(xml의 <selectkey>가 작동)
        seqId = complain.getId();
        logger.info("complain.getID - seqId : {}", seqId);

        return complainDao.findById(seqId);
    }

    // id로 회원 삭제
    @Override
    public boolean deleteById(Long id) {
        long queryResult = 0;

        // complainDao.deleteComplain(id)가 실행되면 실행된 건수가 저장됨
        queryResult = complainDao.deleteComplain(id);

        // queryResult에 건수가 정상저장되면 true값을 반환
        return queryResult >= 1;
    }

    // 회원 전부 삭제
    @Override
    public boolean deleteAll() {
        long queryResult = 0;

        // complainDao.deleteAll가 실행되면 실행된 건수가 저장됨
        queryResult = complainDao.deleteAll();

        // queryResult에 건수가 정상저장되면 true값을 반환
        return queryResult >= 1;
    }
}
