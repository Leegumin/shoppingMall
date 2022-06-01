import axios from 'axios'

// *axios를 호출할 때 마다 create 안에 있는 정보를 자동으로 만들어줌
export default axios.create({
  baseURL: 'http://localhost:8080/api',
  headers: {
    'Content-type': 'application/json',
  },
})