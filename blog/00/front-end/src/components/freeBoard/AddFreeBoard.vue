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
               v-model = "freeBoard.title"
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
               v-model = "freeBoard.content"
        >
      </div>
      <!--*div mb-3 #2 끝-->
      <!--*div mb-3 #3 시작-->
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
               v-model = "freeBoard.writer"
        >
      </div>
      <!--*div mb-3 #3 끝-->
      <div class = "mb-3">
        <button @click = "saveFreeBoard"
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
      <button @click = "newFreeBoard"
              class = "btn btn-primary"
      >
        Add New Board
      </button>
    </div>
  </div>
</template>

<script>
import FreeBoardDataService from '@/services/FreeBoardDataService'

export default {
  name: 'add-freeBoard',
  data () {
    // 객체, 변수 초기화
    return {
      freeBoard: {
        id     : null,
        title  : '',
        content: '',
        writer : '',
      },
      submitted: false,
    }
  },
  methods: {
    // 저장 메소드 호출
    saveFreeBoard () {
      // 회원 임시 객체 만들기
      var data = {
        title  : this.freeBoard.title,
        content: this.freeBoard.content,
        writer : this.freeBoard.writer,
      }
      // 임시 회원 객체를 서버쪽으로 전달해서 DB에 insert 요청
      FreeBoardDataService.create(data)
          // 성공하면 then
          .then(response => {
            this.freeBoard.id = response.data.id
            this.submitted = true // DB insert 성공
          })
          // 실패하면 catch
          .catch(e => {
            alert(e)
          })
    },
    // 새 회원가입을 위한 빈 form을 만드는 메소드 (변수 초기화)
    newFreeBoard () {
      this.submitted = false
      this.freeBoard = {}
    },
  },
}
</script>

<style scoped>

</style>