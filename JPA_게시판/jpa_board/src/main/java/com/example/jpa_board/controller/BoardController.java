package com.example.jpa_board.controller;

import com.example.jpa_board.dto.BoardDto;
import com.example.jpa_board.entity.Board;
import com.example.jpa_board.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * packageName : com.example.jpa_board.controller
 * fileName : BoardController
 * author : Mingu
 * date : 2022-09-21
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-21         Mingu          최초 생성
 */
@Controller
@RequestMapping("/jpa")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    // 글쓰기&수정 Form
    // *글쓰기 혹은 수정 Form의 여부를 결정하기 위해 id값을 매개변수로 받음
    @GetMapping("/boardWrite")
    public String boardWriteForm(Model model,
                                 @RequestParam(value = "id", required = false)
                                 Long id) {
        logger.info("boardWriteForm 실행됨");
        logger.info("id : {}", id);

        // id값이 있다면 해당 id값을 board 정보를 넘겨주고 수정 form으로 변환
        if (id != null) {
            // *findById(pk값) : 매개변수(기본 키) 값을 통해 매칭되는 정보를 DB에서 가져옴
            // *orElse : null 값 체크를 해서 null 값이면 other 값으로 바꿔줌
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("boardDto", board);
            model.addAttribute("formTitle", "Modification");

            logger.info("board : {} ", board);
        }

        // 글쓰기(id값이 null(0))
        else {
            // *새 글을 쓰기 위해 빈 객체를 넘겨 초기화
            model.addAttribute("boardDto", new BoardDto());
            model.addAttribute("formTitle", "NewWrite");
        }

        return "jpa/boardWrite";
    }

    // 글쓰기&수정 등록
    @PostMapping("/boardWrite")
    public String boardWriteSaveUpdate(Model model,
                                       @ModelAttribute
                                       BoardDto boardDto) {
        logger.info("boardWriteSaveUpdate 실행됨");
        logger.info("boardDto : {}", boardDto);

        try {

            // DTO를 Entity로 변환
            // Repository로 Entity를 DB에 저장 memberDTO로 받은 정보 => Entity Member로 변환 => MemberRepository로 저장
            Board board = boardDto.toEntity();

            // TODO : 현재 글쓴날, 수정한날 값을 따로 처리하기 위해 각 방법을 달리함. 더 간결하게 할 수 있으면 수정해볼 것
            // *save 메서드의 경우 기본 키 값이 없을 경우 등록(CREATE), 있을 경우
            // *수정(UPDATE)을 자동으로 처리 => 뷰페이지단에서 반드시 기본 키 값이 넘어와야한다는 소리임
            // 새 글 생성
            if (boardDto.getId() == null) {
                logger.info("createBoard : {}", board);

                // 삭제여부 설정
                board.setDeleteYn('N');
                // 글쓴 날 설정
                board.setCreatedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
            // 기존 글 수정
            else {
                // *boardDto.toEntity() 작동 시 boardDto의 변수 값을 제외한 모든 변수값이 초기화 되므로
                // *id를 통해 기존 정보를 끌고와서 다시 저장하는 작업을 진행
                Board originBoard = boardRepository.findById(boardDto.getId()).orElse(null);
                logger.info("originBoard : {}", originBoard);

                // *글쓴 날 정보 재설정
                board.setCreatedDate(originBoard.getCreatedDate());
                // *삭제여부 재설정
                board.setDeleteYn(originBoard.getDeleteYn());
                // *수정이 일어나는 부분이므로 수정 날 설정
                board.setModifiedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                
                logger.info("updateBoard : {}", board);
            }
            boardRepository.save(board);
        }
        catch (Exception e) {
            logger.info("글 쓰기, 수정 에러 : {}", e);
        }
        return "redirect:/";
    }

    // 글 조회
    @GetMapping("/boardList")
    public String BoardList(Model model,
                            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC)
                            Pageable pageable,
                            @RequestParam(value = "searchKeyword", required = false, defaultValue = "")
                            String searchKeyword) {
        // *변수 초기화
        Page<Board> boards = null;

        // searchKeyword가 없을 때 전체 조회
        // TODO : DeleteYn이 'N'인 게시글만 조회로 수정
        if (searchKeyword.isEmpty()) {
            logger.info("전체 조회");
            boards = boardRepository.findAll(pageable);
        }
        // searchKeyword가 있을 때 검색 조회
        // TODO : DeleteYn이 'N'인 게시글만 조회로 수정
        else {
            logger.info("검색(제목&내용) 조회");
            boards = boardRepository.findByTitleOrContentContains(searchKeyword, searchKeyword, pageable);
        }

        model.addAttribute("boards", boards);
        model.addAttribute("searchKeyword", searchKeyword);

        return "jpa/boardList";
    }

    // 글 상세 조회
    @GetMapping("/boardDetail")
    public String boardDetail(Model model,
                              @RequestParam(value = "id", required = false)
                              Long id) {
        logger.info("boardDetail 실행");

        // *id(pk)에 해당하는 회원 조회
        Board board = boardRepository.findById(id).orElse(null);
        model.addAttribute("board", board);

        return "jpa/boardDetail";
    }

    // 글 삭제
    @GetMapping("/boardDelete")
    public String boardDelete(Model model,
                              @RequestParam(value = "id", required = false)
                              Long id) {
        logger.info("boardDelete 실행");

        // *id(pk)에 해당하는 회원 조회
        Board board = boardRepository.findById(id).orElse(null);
        // *board의 DeleteYn을 'Y'로 변경
        Objects.requireNonNull(board).setDeleteYn('Y');
        // *DB에 다시 저장
        boardRepository.save(board);
        // *List 페이지로 다시 보냄
        return "redirect:/jpa/boardList";
    }
    
    // TODO : 조회수 컨트롤러 정의
}
