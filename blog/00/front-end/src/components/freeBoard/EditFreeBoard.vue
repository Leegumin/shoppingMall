<template>
  <!--기존 회원이 있을 경우 currentFreeBoards != null이 아닐 경우, 현재 상태는 currentFreeBoards null-->
  <div v-if = "currentFreeBoards" class="container mt-3">
    <!--! mb-3 : m(margin), p(padding), : l(left), r(right), b(bottom), 1 : 25px ~ -->
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
             v-model = "currentFreeBoards.title"
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
             v-model = "currentFreeBoards.content"
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
             v-model = "currentFreeBoards.writer"
      >
    </div>
    <!--*div mb-3 #3 끝-->
    <!--*div mb-3 #4 시작-->
    <div class = "mb-3">
      <button @click = "updateFreeBoards"
              class = "btn btn-primary me-3"
      >Update
      </button>
      <button @click = "deleteFreeBoards"
              class = "btn btn-danger me-3"
      >Delete
      </button>
    </div>
    <div class = "alert alert-success"
         role = "alert"
         v-if = "message"
    >
      {{ message }}
    </div>
  </div>
</template>

<script>
import FreeBoardsDataService from '@/services/FreeBoardDataService'

export default {
  name: 'edit-freeBoard',
  data () {
    return {
      currentFreeBoards: null,
      message        : '',
    }
  },
  methods: {
    // id에 해당하는 회원정보를 조회하는 서비스 요청
    getFreeBoards (id) {
      FreeBoardsDataService.get(id)
          // * 성공하면 then ( 결과데이터 response.data가 들어옴 )
          .then(response => {
            this.currentFreeBoards = response.data
          })
          // * 실패하면 catch
          .catch(e => {
            alert(e)
          })
    },
    // 회원정보 수정 서비스 요청
    updateFreeBoards () {
      FreeBoardsDataService.update(this.currentFreeBoards.id, this.currentFreeBoards)
          // * 성공하면 then
          .then(response => {
            console.log(response.data)
            this.message = 'The Boards was updated successfully!'
          })
          // * 실패하면 catch
          .catch(e => {
            alert(e)
          })
    },
    // 회원 삭제 서비스 요청
    deleteFreeBoards () {
      FreeBoardsDataService.delete(this.currentFreeBoards.id)
          // * 성공하면 then
          .then(response => {
            console.log(response.data)
            // * 회원정보 삭제 후 회원정보 전체 리스트가 있는 곳으로 이동
            // * $router.push에 관한 설명은 아래 참고
            // * https://router.vuejs.org/guide/essentials/navigation.html#navigate-to-a-different-location
            // * index.js의 name으로 지정하는 방식(Json 형태로 데이터 기입)
            this.$router.push({ name: 'free-boards' })
            // * url로 지정하는 방식
            // this.$router.push('/freeBoards')
          })
          // * 실패하면 catch
          .catch(e => {
            alert(e)
          })
    },
  },
  // 화면이 뜨면 실행
  // * http://localhost:8080/:id
  // * $route : router/index.js에 접근, params 중 'id'로 정의된 변수를 가져옴
  mounted () {
    this.getFreeBoards(this.$route.params.id)
  },
}
</script>

<style scoped>

</style>