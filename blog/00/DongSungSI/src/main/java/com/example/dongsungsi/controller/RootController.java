package com.example.dongsungsi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName : com.example.dongsungsi.controller
 * fileName : RootController
 * author : gumin
 * date : 2022-06-14
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-14         gumin          최초 생성
 */
// npm run bulid로 배포시 새로고침이 안될때 강제적인 redirect를 주는 클래스
@Controller
public class RootController implements ErrorController {

    // 에러(Not Found)가 발생하면 강제적으로 index.html(static에 있는 파일) 주소로 변경(redirect)
    @GetMapping("/error")
    public String redirectRoot() {
        return "index.html";
    }
}
