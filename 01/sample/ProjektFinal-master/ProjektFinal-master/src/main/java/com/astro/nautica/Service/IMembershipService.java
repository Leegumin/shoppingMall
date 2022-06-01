package com.astro.nautica.Service;

import com.astro.nautica.VO.MemberVO;
import com.astro.nautica.VO.ProductVO;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

public interface IMembershipService {
    // id 존재 확인
    int isExistId(String id);

    // 입력받은 id, pw 를 DB 와 비교하기
    boolean login(String id, String pw, @ModelAttribute("userInfo") Map<String, Object> userInfo);

    // email 로 id 찾기
    String findId(String email);

    // pw 변경하기
    boolean changePw(String data, String pw, String pwOk);

    // 회원가입
    boolean makeMember(MemberVO memberVO);

}
