// axios 사용법
// ex) get방식 : axios.get('/user/12345')
//     post방식 : axios.post('/user', {id: 'aa', name: 'forbob'})
//     axios : get, post, put, delete
//     axios.post('/user, {id: 'aa', name: 'forbob'})
//     .then(function(res) { 성공하면 then })
//     .catch(function(error) { 실패하면 catch })

import http from '../http-common'

// 자바스크립트 class
class TutorialDataService {
  // tutorials 전체 목록 조회 메소드
  // *axios -> spring 데이터 요청 -> spring -> db -> 결과 반환
  getAll () {
    return http.get('/tutorials')
  }

  // id로 조회하는 메소드
  get (id) {
    return http.get(`/tutorials/${ id }`)
  }

  // tutorial 데이터 추가 메소드
  create (data) {
    return http.post('/tutorials', data)
  }

  // tutorial 데이터 수정 메소드
  update (id, data) {
    return http.put(`/tutorials/${ id }`, data)
  }

  // tutorial 데이터 삭제 메소드
  delete (id) {
    return http.put(`/tutorials/deletion/${ id }`)
  }

  // tutorial 모든 데이터 삭제 메소드
  deleteAll () {
    return http.put(`/tutorials`)
  }

  // tutorial 데이터 중에 title(제목)을 기준으로 검색하는 메소드
  // * 전통적인 웹 개발 방식을 spring에서도 사용중이라서 url 주소도 똑같은 방식으로 들어가야함
  // * URL : http://loccalhost:8080/board?name=forbob 
  findByTitle (title) {
    return http.get(`/tutorials?title=${ title }`)
  }
}

// 모듈 다른 자바스크립트 파일에서 참조함
// new 모듈명 : class 객채생성을 위해 new(새 객채 생성)을 사용함
export default new TutorialDataService();