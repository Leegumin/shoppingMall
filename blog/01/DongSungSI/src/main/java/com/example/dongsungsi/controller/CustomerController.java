package com.example.dongsungsi.controller;

import com.example.dongsungsi.model.Customer;
import com.example.dongsungsi.paging.Criteria;
import com.example.dongsungsi.service.CustomerServiceImp;
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
 * fileName : CustomerController
 * author : gumin
 * date : 2022-06-07
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-07         gumin          최초 생성
 */
// *@CrossOrigin
// *웹 페이지의 제한(CORS(Cross-origin resource sharing) 문제)된 자원을 외부 도메인에서 접근을 허용해주는 매커니즘
// *기본적으로 '모든 도메인, 모든 요청방식'에 대해 허용 한다는 뜻
// *(origins = "http://localhost:8080") : 특정 도메인만 허용할 경우 origins에 주소가 들어감. 도메인이 복수개일 경우 ','로 구분
// *front-end와 연결하기 위해 사용함
@CrossOrigin(origins = "http://localhost:8080")
// *Json 데이터로 주고 받는 어노테이션
@RestController
// *@RequestMapping("/api") : http://localhost:8000/ -> http://localhost:8000/api로 기본주소 변경됨
@RequestMapping("/api")
public class CustomerController {

    // logger을 찍기 위한 객체생성
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerServiceImp customerService;

    // 회원 생성
    @PostMapping("/customers")
    public ResponseEntity<Object> createCustomers(
            @RequestBody
            Customer customer) {
        // 회원 생성 메서드 호출
        // *save(customer)은 Optional<Customer>인데 거기서 데이터를 꺼내기 위해 .get을 붙임
        // *혹은 Optional<Customer> savedCustomer = customerService.save(customer); 로 형을 맞춰줘도 됨
        Customer savedCustomer = customerService.save(customer).get();

        // * 성공하면 savedCustomer와 OK 메시지 송출
        try {
            return new ResponseEntity<Object>(savedCustomer, HttpStatus.OK);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // Vue에 보낼 에러 메세지 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // id로 회원 조회 메뉴
    @GetMapping("/customers/{id}")
    public ResponseEntity<Object> getCustomerById(
            @PathVariable("id")
            Long id) {
        // id로 회원 조회하는 서비스 호출
        // *save(customer)은 Optional<Customer>인데 거기서 데이터를 꺼내기 위해 .get을 붙임
        Customer customer = customerService.findById(id).get();

        // * 성공하면 customer, OK 메시지 송출
        try {
            // * id값을 찾았을 경우
            if (customer != null) {
                return new ResponseEntity<Object>(customer, HttpStatus.OK);
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
    @GetMapping("/customers")
    public ResponseEntity<Map<String, Object>> getAllEmailPage(Criteria criteria) {
        logger.info("criteria1 : {}", criteria);
        // *email을 조회하는 서비스를 호출, totalItem과 totalPages 계산 기능 포함(현재 null)
        List<Customer> customers = customerService.findByEmailContaining(criteria);
        // *findByEmailContaining이 호출되면서 totalItem과 totalPages 값도 같이 나옴
        logger.info("customers: {}", customers);
        try {
            // *조회데이터가 없을 때
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            logger.info("criteria2 : {}", criteria);

            Map<String, Object> response = new HashMap<>();
            response.put("customers", customers);
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
    // * 객체(data) : @RequestBody Customer customer, Vue에서 객체를 Json 형태로 받는 어노테이션
    @PutMapping("/customers/{id}")
    public ResponseEntity<Object> updateCustomer(
            @RequestBody
            Customer customer,
            @PathVariable("id")
            Long id
    ) {

        // * 성공하면 customer, OK 메시지 송출
        try {
            // customer 객체에 id값 저장 ( update할 내용에 id값은 없기 때문에 null 값 상태임 )
            customer.setId(id);
            // 업데이트 실행 후 데이터 저장
            Customer savedCustomer = customerService.save(customer).get();
            // Vue로 다시 db에 업데이트 후 저장된 데이터, 메시지 전송
            return new ResponseEntity<Object>(savedCustomer, HttpStatus.OK);
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // Vue에 보낼 에러 메세지 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // * 삭제는 데이터를 굳이 보낼 필요가 없기 때문에 Object 대신 상태메시지인 HttpStatus 형태
    @PutMapping("/customers/deletion/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(
            @PathVariable("id")
            Long id) {

        // * 성공하면 customer, OK 메시지 송출
        try {
            // 삭제(업데이트) 실행 후 데이터 저장
            customerService.deleteById(id);
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
