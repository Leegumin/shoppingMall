package com.example.dongsungsi.controller;

import com.example.dongsungsi.message.ResponseFile;
import com.example.dongsungsi.message.ResponseMessage;
import com.example.dongsungsi.model.FileDB;
import com.example.dongsungsi.service.FileDBService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName : com.example.dongsungsi.controller
 * fileName : FileController
 * author : gumin
 * date : 2022-05-31
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-31         gumin          최초 생성
 */
// *@CrossOrigin
// *웹 페이지의 제한(CORS(Cross-origin resource sharing) 문제)된 자원을 외부 도메인에서 접근을 허용해주는 매커니즘
// *기본적으로 '모든 도메인, 모든 요청방식'에 대해 허용 한다는 뜻
// *(origins = "http://localhost:8080") : 특정 도메인만 허용할 경우 origins에 주소가 들어감. 도메인이 복수개일 경우 ','로 구분
// *front-end와 연결하기 위해 사용함
//@CrossOrigin(origins = "http://localhost:8080")
// *가져오는게 파일데이터라 Controller
@Controller
// *@RequestMapping("/api") : http://localhost:8000/ -> http://localhost:8000/api로 기본주소 변경됨
@RequestMapping("/api")
public class FileDBController {
    // 디버깅을 위한 로거 클래스 객체 생성
    Logger logger = LoggerFactory.getLogger(this.getClass());

    // @Autowired : 스프링 객체를 받아옴
    @Autowired
    private FileDBService fileDBService;

    // 이미지 업로드를 위한 메뉴(insert 호출)
    // @RequestParam("file") : Vue에서 전송하는 형태가 Post일때 params = file
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(
            @RequestParam("file")
            MultipartFile file) {
        String message;

        logger.info("file : {}", file);

        try {
            // Vue 전송할 업로드 이미지를 DB에 저장(insert문 호출)
            fileDBService.store(file);

            // Vue에 보낼 메세지 성공
            message = "Uploaded the file successfully : " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }
        catch (Exception e) {
            // Vue에 보낼 메세지 실패
            message = "Could not upload the file : " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]>
    getFile(
            @PathVariable("id")
            String id) {
        // DB Select 호출
        FileDB fileDB = fileDBService.getFile(id);
        // "attachment: filename=\"" + fileDB.getName() + "\"" : 헤더정보(이미지 이름)
        // body(fileDB.getData()); : 바디정보(이미지)
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                                          "attachment; filename=\"" + fileDB.getName() + "\"").body(fileDB.getData());
    }

    // 모든 이미지 목록을 조회하는 메뉴
    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = fileDBService.getAllFile().map(dbFile -> {
            // 첨부파일을 다운로드할 위치 URL 만들어야 함
            // Vue 클릭 시 이미지 다운로드 가능
            // <img src ="'C:/work/upload' 를 변환 => <img src='http://loaclhost:9000/api/files/1'">
            String fileDownloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                                                                .path("/api/files/")
                                                                .path(dbFile.getId())
                                                                .toUriString();
            // Vue로 전송할 데이터 반환 ( 파일번호, 파일이름, URL, 파일유형, 파일크기 )
            return new ResponseFile(dbFile.getId(), dbFile.getName(), fileDownloadURL, dbFile.getType(),
                                    dbFile.getData().length
            );

            // 반환된 Stream => List로 원상복구
        }).collect(Collectors.toList());
        // Vue 이미지 데이터 전송
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
}
