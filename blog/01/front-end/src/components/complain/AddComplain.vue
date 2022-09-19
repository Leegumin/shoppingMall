<template>
  <div class = "container mt-3">
    <!--새 회원가입일 경우 submitted = false -->
    <div v-if = "!submitted">
      <!--*div mb-3 #1 시작-->
      <div class = "mb-3">
        <label for = "title"
               class = "form-label"
        >
          제목
        </label>
        <input type = "text"
               class = "form-control"
               id = "title"
               required
               name = "title"
               v-model = "complain.title"
        >
      </div>
      <!--*div mb-3 #1 끝-->
      <!--*div mb-3 #2 시작-->
      <div class = "mb-3">
        <label for = "content"
               class = "form-label"
        >
          Complain 내용
        </label>
        <input type = "text"
               class = "form-control"
               id = "content"
               required
               name = "content"
               v-model = "complain.content"
        >
      </div>
      <!--*div mb-3 #2 끝-->
      <!--*div mb-3 #3 시작-->
      <div class = "mb-3">
        <label for = "targetPage"
               class = "form-label"
        >
          대상 페이지
        </label>
        <input type = "email"
               class = "form-control"
               id = "targetPage"
               required
               name = "targetPage"
               v-model = "complain.targetPage"
        >
      </div>
      <!--*div mb-3 #3 끝-->
      <!--*div mb-3 #4 시작-->
      <div class = "mb-3">
        <label for = "writer"
               class = "form-label"
        >
          작성자
        </label>
        <input type = "text"
               class = "form-control"
               id = "writer"
               required
               name = "writer"
               v-model = "complain.writer"
        >
      </div>
      <!--*div mb-3 #4 끝-->
      <div class = "mb-3">
        <button @click = "saveComplain"
                class = "btn btn-primary"
        >Submit
        </button>
      </div>
    </div>
    <!--저장 버튼을 눌렀을 경우-->
    <div v-else>
      <div class = "alert alert-success"
           role = "alert"
      >
        Save complain successfully!
      </div>
      <button @click = "newComplain"
              class = "btn btn-primary"
      >
        Add New Complain
      </button>
    </div>
  </div>
</template>

<script>
import ComplainDataService from '@/services/ComplainDataService'

export default {
  name: 'add-complain',
  data () {
    // 객체, 변수 초기화
    return {
      complain : {
        id        : null,
        title     : '',
        content   : '',
        targetPage: '',
        writer    : '',
      },
      submitted: false,
    }
  },
  methods: {
    // 저장 메소드 호출
    saveComplain () {
      // 서버로 보낼 회원정보 임시 객체 만들기
      var data = {
        title     : this.complain.title,
        content   : this.complain.content,
        targetPage: this.complain.targetPage,
        writer    : this.complain.writer,
      }
      // 임시 회원 객체를 서버쪽으로 전달해서 DB에 insert 요청
      ComplainDataService.create(data)
          // 성공하면 then
          .then(response => {
            this.complain.id = response.data.id
            this.submitted = true // DB insert 성공
          })
          // 실패하면 catch
          .catch(e => {
            alert(e)
          })
    },
    // 새 회원가입을 위한 빈 form을 만드는 메소드 (변수 초기화)
    newComplain () {
      this.submitted = false
      this.complain = {}
    },
  },
}
</script>

<style scoped>

</style>