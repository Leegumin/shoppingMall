import http from '../http-common'

class UploadFilesService {
  // upload를 위한 메소드 -> insert문 호출
  upload (file, onUploadProgress) {
    // *FormData : 자바스크립트에서 제공하는 클래스, JSON 형태가 아닌 이미지 파일을 받기 위해 사용
    // *<form> 형태로 이미지 전송을 가능하게 해줌
    let formData = new FormData()
    // "file"이란 이름의 file 매개변수를 form 데이터로 담음
    formData.append('file', file)

    // form에 담은 데이터를 보내는 값을 리턴
    return http.post('/upload', formData, {
      headers: {
        'Content-Type': 'application/form-data',
      },
      // 이미지 처리 결과를 화면에 프로그래스바로 보여주기위해 실행하는 함수
      onUploadProgress,
    })
  }

  // 이미지를 서버에서 다운로드 받음 -> select문 호출
  getFiles () {
    return http.get('/files')
  }
}

export default new UploadFilesService()