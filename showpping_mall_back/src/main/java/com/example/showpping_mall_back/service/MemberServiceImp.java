package com.example.showpping_mall_back.service;

import com.example.showpping_mall_back.dao.MemberDao;
import com.example.showpping_mall_back.model.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName : com.example.showpping_mall_back.service
 * fileName : MemberServiceImp
 * author : Mingu
 * date : 2022-05-31
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-31         Mingu          최초 생성
 */
@Service
public class MemberServiceImp implements MemberService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberDao memberDao;

    // 회원가입, insert
    @Override
    public boolean save(Member member) {
        String queryResult;
        logger.info("Member : {} ", member);
        logger.info("Member : {} ", member.getUserId());
        // *id값이 없을때 insert문 실행됐는지 여부 파악
        if (member.getUserId() != null) {
            // *insertTutorial(tutorial); -> 처음 호출되는 순간 insertTutorial에 데이터가 저장되어 Tutorial.xml의 insert문 실행 가능해짐
            queryResult = memberDao.registerMember(member);
            logger.info("queryResult : {} ", queryResult);
        }
        // *id값이 있을때 update문 실행됐는지 여부 파악
        else {
            queryResult = null;
        }
        return queryResult != null;
    }

    /*@Autowired
    private TutorialDao tutorialDao;

    @Override
    public Optional<Tutorial> findById(Long id) {
        return tutorialDao.findById(id);
    }

    @Override
    public List<Tutorial> findByPublished(String published) {
        return tutorialDao.findByPublished(published);
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        // *빈 값으로 초기화
        List<Tutorial> tutorials = Collections.emptyList();
        if (title == null) {
            // *타이틀 값이 null 값이면 빈 값으로 초기화한 tutorials에 전체 값을 반환
            tutorials = tutorialDao.findAll();
            // *타이틀 값이 있으면 매개변수로 들어가는 title의 값과 일치하는 title 변수를 가진 Tutorial을 배열로 반환함
        }
        else {
            tutorials = tutorialDao.findByTitleContaining(title);
        }
        return tutorials;
    }

    @Override
    public List<Tutorial> findAll() {
        return tutorialDao.findAll();
    }

    @Override
    public boolean save(Tutorial tutorial) {
        int queryResult = 0;
        logger.info("Tutorial : {} ", tutorial);

        // *id값이 없을때 insert문 실행됐는지 여부 파악
        if (tutorial.getId() == null) {
            // *insertTutorial(tutorial); -> 처음 호출되는 순간 insertTutorial에 데이터가 저장되어 Tutorial.xml의 insert문 실행 가능해짐
            queryResult = tutorialDao.insertTutorial(tutorial);
            logger.info("queryResult : {} ", queryResult);

        }
        // *id값이 있을때 update문 실행됐는지 여부 파악
        else {
            queryResult = tutorialDao.updateTutorial(tutorial);
        }
        return queryResult > 0;
    }

    // 메소드가 실행 됐는지 안됐는지를 알 수 있는 메소드(참, 거짓 값)
    @Override
    public boolean deleteById(Long id) {
        int queryResult = 0;
        queryResult = tutorialDao.deleteTutorial(id);
        return queryResult > 0;
    }

    @Override
    public boolean deleteAll() {
        int queryResult = 0;
        queryResult = tutorialDao.deleteAll();
        return queryResult > 0;*/
}
