package com.example.showpping_mall_back.controller;

import com.example.showpping_mall_back.model.Member;
import com.example.showpping_mall_back.service.MemberServiceImp;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.example.showpping_mall_back.controller
 * fileName : Controller
 * author : Mingu
 * date : 2022-05-31
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-31         Mingu          최초 생성
 */
// *@RestController : REST API 호출을 위한 어노테이션, JSON 형태로 들어옴
@RestController
// *@RequestMapping("/api") : http://localhost:8000/ -> http://localhost:8000/api로 기본주소 변경됨
@RequestMapping("/api")
@NoArgsConstructor
public class Controller {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberServiceImp memberService;

//    암호화 보류
    @Autowired
    PasswordEncoder passwordEncoder;

    // 회원가입, insert
    // *ResponseEntity : frontend 요청 시 객체를 결과로 전달
    // *@RequestBody : 클라이언트가 전송하는 Json(application/json) 형태의 HTTP Body 내용을 Java Object로 변환시켜주는 역할
    @PostMapping("/registerMember")
    public ResponseEntity<Member> registerMember(
            @RequestBody
            Member member) {
        logger.info("registerMember - member : {} ", member);
        passwordEncoder.encode(member);
        // *성공 여부 판단
        boolean bSuccess = memberService.save(member);
        logger.info("bSuccess : {} ", bSuccess);
        try {
            // !if (bSuccess == true) 밑에 조건과 동일함
            if (bSuccess) {
                // *정상 실행이 된 경우
                // *ResponseEntity<>(매개변수 객체, 출력할 상태정보);
                return new ResponseEntity<>(member, HttpStatus.CREATED);
            }
            // *찾을 수 없는 경우 : NOT_FOUND를 프론트엔드로 전송
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            // *DB 에러가 났을 경우 : INTERNAL_SERVER_ERROR 프론트엔드로 전송
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
