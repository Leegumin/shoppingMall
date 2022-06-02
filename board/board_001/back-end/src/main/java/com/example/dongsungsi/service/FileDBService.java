package com.example.dongsungsi.service;

import com.example.dongsungsi.dao.FileDBDao;
import com.example.dongsungsi.model.FileDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * packageName : com.example.dongsungsi.service
 * fileName : FileDBService
 * author : gumin
 * date : 2022-06-02
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-02         gumin          최초 생성
 */
@Service
public class FileDBService {

    // 디버깅을 위한 로거 클래스 객체 생성
    Logger logger = LoggerFactory.getLogger(this.getClass());

    // @Autowired : 스프링 객체를 받아오는 어노테이션
    @Autowired
    private FileDBDao fileDBDao;

    // insert문 호출하는 서비스(업로드 이미지 DB 저장됨)
    public int store(MultipartFile file) throws IOException {
        // 매개변수로 들어오는 이미지파일의 경로를 제거해서 순수 파일이름만 얻기
        // ex file = c:/work/uploads/image.jpg => image.jpg
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        FileDB fileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

        // DB에 insert문 호출
        return fileDBDao.save(fileDB);
    }

    // 이미지 정보 가져오기 서비스 ( 결과 : 한 건 )
    public FileDB getFile(String id) {
        return fileDBDao.findById(id);
    }

    // 모든 이미지 정보를 가져오는 서비스 ( 결과 : 여러 건 )
    public Stream<FileDB> getAllFile() {
        // List, Map, Set => 인터페이스
        // ArrayList, HashMap, HashSet
        // List, Map, Set => Stream 변환 가능
        // Stream => List, Map, Set 변환 가능
        // Stream으로의 변환 목적 : 편한 함수들을 쓰기 위해서 ( map, foreach, filter )
        // List => Stream 객체 변환
        Stream<FileDB> resFileDB = fileDBDao.findAll().stream();
        return resFileDB;
    }
}
