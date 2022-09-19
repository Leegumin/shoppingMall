package com.example.dongsungsi.controller;

import com.example.dongsungsi.model.FAQBoard;
import com.example.dongsungsi.paging.Criteria;
import com.example.dongsungsi.service.FAQBoardServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName : com.example.dongsungsi.controller
 * fileName : FAQBoardController
 * author : Mingu
 * date : 2022-06-15
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-15         Mingu          최초 생성
 */
@CrossOrigin(origins = "http://localhost:8080")
// *Json 데이터로 주고 받는 어노테이션
@RestController
// *@RequestMapping("/api") : http://localhost:8000/ -> http://localhost:8000/api로 기본주소 변경됨
@RequestMapping("/api")
public class FAQBoardController {

    // logger을 찍기 위한 객체생성
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FAQBoardServiceImp faqBoardService;

    // 회원 생성
    @PostMapping("/faq-boards")
    public ResponseEntity<Object> createFAQBoards(
            @RequestBody
            FAQBoard faqBoard) {
        // 회원 생성 메서드 호출
        // *save(faqBoard)은 Optional<FAQBoard>인데 거기서 데이터를 꺼내기 위해 .get을 붙임
        // *혹은 Optional<FAQBoard> savedFAQBoard = faqBoardService.save(faqBoard); 로 형을 맞춰줘도 됨
        FAQBoard savedFAQBoard = faqBoardService.save(faqBoard).get();

        // * 성공하면 savedFAQBoard와 OK 메시지 송출
        try {
            return new ResponseEntity<Object>(savedFAQBoard, HttpStatus.OK);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // Vue에 보낼 에러 메세지 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // id로 회원 조회 메뉴
    @GetMapping("/faq-boards/{id}")
    public ResponseEntity<Object> getFAQBoardById(
            @PathVariable("id")
            Long id) {
        // id로 회원 조회하는 서비스 호출
        // *save(faqBoard)은 Optional<FAQBoard>인데 거기서 데이터를 꺼내기 위해 .get을 붙임
        FAQBoard faqBoard = faqBoardService.findById(id).get();

        // * 성공하면 faqBoard, OK 메시지 송출
        try {
            // * id값을 찾았을 경우
            if (faqBoard != null) {
                return new ResponseEntity<Object>(faqBoard, HttpStatus.OK);
            }
            // * id값을 못찾았을 경우
            else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // Vue에 보낼 에러 메세지 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // Todo: 추가 getAllEmailPage
    // EMAIL 검색 (검색조건이 없을 때 모든 회원 조회)
    @GetMapping("/faq-boards")
    public ResponseEntity<Map<String, Object>> getAllTitlePage(Criteria criteria) {
        logger.info("criteria1 : {}", criteria);
        // *title을 조회하는 서비스를 호출, totalItem과 totalPages 계산 기능 포함(현재 null)
        List<FAQBoard> faqBoards = faqBoardService.findByTitleContaining(criteria);
        // *findByEmailContaining이 호출되면서 totalItem과 totalPages 값도 같이 나옴
        logger.info("faqBoards: {}", faqBoards);
        try {
            // *조회데이터가 없을 때
            if (faqBoards.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            logger.info("criteria2 : {}", criteria);

            Map<String, Object> response = new HashMap<>();
            response.put("faqBoards", faqBoards);
            // *page : 현재페이지
            response.put("currentPage", criteria.getPage());
            // *totalItems : 총 데이터 건수
            response.put("totalItems", criteria.getTotalItems());
            // *totalPage : 총 페이지 개수
            response.put("totalPage", criteria.getTotalPages());

            // *조회데이터가 있을 때 :tutorials, 상태정보 (OK) 전송
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // id로 회원 수정
    // * Vue에서 전송받아야 하는 것 : url 매개변수({id}), 객체(data)
    // * url 매개변수({id}) : @PathVariable("id") Long id), Vue에서 url 매개변수를 받는 어노테이션
    // * 객체(data) : @RequestBody FAQBoard faqBoard, Vue에서 객체를 Json 형태로 받는 어노테이션
    @PutMapping("/faq-boards/{id}")
    public ResponseEntity<Object> updateFAQBoard(
            @RequestBody
            FAQBoard faqBoard,
            @PathVariable("id")
            Long id) {

        // * 성공하면 faqBoard, OK 메시지 송출
        try {
            // faqBoard 객체에 id값 저장 ( update할 내용에 id값은 없기 때문에 null 값 상태임 )
            faqBoard.setId(id);
            // 업데이트 실행 후 데이터 저장
            FAQBoard savedFAQBoard = faqBoardService.save(faqBoard).get();
            // Vue로 다시 db에 업데이트 후 저장된 데이터, 메시지 전송
            return new ResponseEntity<Object>(savedFAQBoard, HttpStatus.OK);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // Vue에 보낼 에러 메세지 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // * 삭제는 데이터를 굳이 보낼 필요가 없기 때문에 Object 대신 상태메시지인 HttpStatus 형태
    @PutMapping("/faq-boards/deletion/{id}")
    public ResponseEntity<HttpStatus> deleteFAQBoard(
            @PathVariable("id")
            Long id) {

        // * 성공하면 faqBoard, OK 메시지 송출
        try {
            // 삭제(업데이트) 실행 후 데이터 저장
            faqBoardService.deleteById(id);
            // Vue로 메시지만 전송해주면 됨 ( 어차피 DELETE_YN = 'Y'는 검색에서 제외되기 때문, 데이터를 굳이 보낼 필요가 없음 )
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // Vue(클라이언트)에 보낼 에러 메세지 전송
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}
