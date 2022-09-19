// axios 사용법
// ex) get방식 : axios.get('/user/12345')
//     post방식 : axios.post('/user', {id: 'aa', name: 'forbob'})
//     axios : get, post, put, delete
//     axios.post('/user, {id: 'aa', name: 'forbob'})
//     .then(function(res) { 성공하면 then })
//     .catch(function(error) { 실패하면 catch })
//     http.axios형식('/spring에서 정의된 주소'), router의 index.js 주소와는 관계 없음
import http from '../http-common'

// 자바스크립트 class
// springboot에 연결하기 위한 메소드 정의
class ComplainDataService {
  // customers 전체 목록 조회 메소드
  // !전체 컴플레인 조회
  // *axios -> spring 데이터 요청 -> spring -> db -> 결과 반환
  // Todo : getAll => getAll(params)
  getAll (params) {
    return http.get('/complains', { params })
  }

  // id로 조회하는 메소드
  // !컴플레인 id값으로 조회
  get (id) {
    return http.get(`/complains/${ id }`)
  }

  // customer 데이터 추가 메소드
  // !컴플레인 데이터 생성
  create (data) {
    return http.post('/complains', data)
  }

  // customer 데이터 수정 메소드
  // !컴플레인 데이터 수정
  update (id, data) {
    return http.put(`/complains/${ id }`, data)
  }

  // customer 데이터 삭제 메소드
  // !컴플레인 데이터 삭제
  delete (id) {
    return http.put(`/complains/deletion/${ id }`)
  }

  // customer 모든 데이터 삭제 메소드
  // !모든 컴플레인 데이터 삭제
  deleteAll () {
    return http.put(`/complains`)
  }

  // customer 데이터 중에 email을 기준으로 검색하는 메소드
  // * 전통적인 웹 개발 방식을 spring에서도 사용중이라서 url 주소도 똑같은 방식으로 들어가야함
  // * URL : http://loccalhost:8080/board?name=forbob
  findByEmail (title) {
    return http.get(`/complains?title=${ title }`)
  }
}

// 모듈 다른 자바스크립트 파일에서 참조함
// new 모듈명 : class 객채생성을 위해 new(새 객채 생성)을 사용함
export default new ComplainDataService()