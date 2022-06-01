package com.example.showpping_mall_back.dao;

import com.example.showpping_mall_back.model.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * packageName : com.example.showpping_mall_back.dao
 * fileName : MemberDao
 * author : Mingu
 * date : 2022-05-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-30         Mingu          최초 생성
 */
@Mapper
public interface MemberDao {

    // insert, 회원가입
    String registerMember(Member member);
}
