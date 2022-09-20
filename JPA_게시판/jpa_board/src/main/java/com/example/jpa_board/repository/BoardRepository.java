package com.example.jpa_board.repository;

import com.example.jpa_board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.example.jpa_board.repository
 * fileName : BoardRepository
 * author : Mingu
 * date : 2022-09-21
 * description : JpaRepository를 상속받는 인터페이스 CRUD를 실행하기 위한 인터페이스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-21         Mingu          최초 생성
 */
// *JpaRepository<entity 타입, entity pk(@Id) 타입>
public interface BoardRepository extends JpaRepository<Board, Long> {

}
