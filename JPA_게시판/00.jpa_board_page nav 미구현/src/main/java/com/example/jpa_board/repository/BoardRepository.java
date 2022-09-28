package com.example.jpa_board.repository;

import com.example.jpa_board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    // 제목&내용 검색
    @Query("select b from Board b where (b.deleteYn='N') and (b.title like %:searchKeyword%) or (b.content like %:searchKeyword%)")
    Page<Board> findByTitleOrContentExceptY(@Param("searchKeyword") String searchKeyword, Pageable pageable);

    // delete_yn이 'Y'(삭제된 글)인 것을 제외하고 조회, entity의 이름을 테이블 명으로 사용함
    @Query("select b from Board b where b.deleteYn ='N'")
    Page<Board> findByAllExceptY(Pageable pageable);
}
