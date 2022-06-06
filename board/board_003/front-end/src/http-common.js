import axios from 'axios'

// *axios를 호출할 때 마다 create 안에 있는 정보를 자동으로 만들어줌
export default axios.create({
  // *back-end 주소(application.properti의 서버 포트)
  baseURL: 'http://localhost:8000/api',
  // *axios를 실행할 때 기본적으로 머리에 붙는 구문
  headers: {
    'Content-type': 'application/json',
  },
})