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
               v-model = "faqBoard.title"
        >
      </div>
      <!--*div mb-3 #1 끝-->
      <!--*div mb-3 #2 시작-->
      <div class = "mb-3">
        <label for = "content"
               class = "form-label"
        >
          내용
        </label>
        <input type = "text"
               class = "form-control"
               id = "content"
               required
               name = "content"
               v-model = "faqBoard.content"
        >
      </div>
      <!--*div mb-3 #2 끝-->
      <div class = "mb-3">
        <button @click = "saveFAQBoard"
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
        Save Board successfully!
      </div>
      <button @click = "newFAQBoard"
              class = "btn btn-primary"
      >
        Add New Board
      </button>
    </div>
  </div>
</template>

<script>
import FAQBoardDataService from '@/services/FAQBoardDataService'

export default {
  name: 'add-faqBoard',
  data () {
    // 객체, 변수 초기화
    return {
      faqBoard : {
        id     : null,
        title  : '',
        content: '',
      },
      submitted: false,
    }
  },
  methods: {
    // 저장 메소드 호출
    saveFAQBoard () {
      // 회원 임시 객체 만들기
      var data = {
        title  : this.faqBoard.title,
        content: this.faqBoard.content,
      }
      // 임시 회원 객체를 서버쪽으로 전달해서 DB에 insert 요청
      FAQBoardDataService.create(data)
          // 성공하면 then
          .then(response => {
            this.faqBoard.id = response.data.id
            this.submitted = true // DB insert 성공
          })
          // 실패하면 catch
          .catch(e => {
            alert(e)
          })
    },
    // 새 회원가입을 위한 빈 form을 만드는 메소드 (변수 초기화)
    newFAQBoard () {
      this.submitted = false
      this.faqBoard = {}
    },
  },
}
</script>

<style scoped>

</style>