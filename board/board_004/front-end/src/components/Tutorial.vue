<template>
  <!--currentTutorial != null 일 때-->
  <div v-if = "currentTutorial"
       class = "edit-form"
  >
    <!--!form 시작-->
    <h4>Tutorial</h4>
    <form>
      <div class = "form-group">
        <label for = "title">Title</label>
        <input type = "text"
               class = "form-control"
               id = "title"
               v-model = "currentTutorial.title"
        >
      </div>
      <div class = "form-group">
        <label for = "description">Description</label>
        <input type = "text"
               class = "form-control"
               id = "description"
               v-model = "currentTutorial.description"
        >
      </div>
      <div class = "form-group">
        <label><Strong>Status: </Strong></label>
        {{
          currentTutorial == 'Y' ? 'Published' : 'Pending'
        }}
      </div>
    </form>

    <!--!버튼 시작-->
    <!--click시 published == 'Y'<=>'N' 토글-->
    <button class = "badge badge-primary mr-2"
            v-if = 'currentTutorial=="Y"'
            @click = "updatePublished(false)"
    >UnPublish
    </button>

    <button class = "badge badge-primary mr-2"
            @click = "updatePublished(true)"
    >Publish
    </button>

    <!--delete 버튼-->
    <button class = "badge badge-danger mr-2"
            @click = "deleteTutorial"
    >Delete
    </button>

    <!--update 버튼-->
    <button type = "submit"
            class = "badge badge-success"
            @click = "updateTutorial"
    >Update
    </button>
    <p>{{ message }}</p>
  </div>
  <!--currentTutorial == null 일 때-->
  <div v-else>
    <br>
    <p>Please click on a Tutorial...</p>
  </div>
</template>

<script>
import TutorialDataService from '../services/TutorialDataService'

// * /* eslint-disable */: name: {}의 단어가 하나라서 나는 오류를 무시해주는 주석
/* eslint-disable */
export default {
  name: 'tutorial',
  data () {
    return {
      currentTutorial: null,
      message        : '',
    }
  },
  methods: {
    // id로 데이터 상세 조회
    // back-end쪽에 spring 요청
    getTutorial (id) {
      // id로 검색을 back-end(spring)쪽에 요청하는 메소드
      TutorialDataService.get(id)
          // *성공하면 then으로
          .then(response => {
            this.currentTutorial = response.data
            console.log(response.data)
          })
          // *실패하면 then으로
          .catch(e => {
            console.log(e)
          })
    },
    // tutorial 데이터 수정 메소드 호출
    updateTutorial () {
      // *back-end쪽에 id로 검색해서 데이터를 수정하도록 요청
      TutorialDataService.update(this.currentTutorial.id, this.currentTutorial)
          // *성공하면 then으로
          .then(response => {
            console.log(response.data)
            this.message = 'The tutorial was updated successfully!'
          })
          // *실패하면 then으로
          .catch(e => {
            console.log(e)
          })
    },

    // tutorial 데이터 삭제 메소드 호출
    deleteTutorial () {
      // *back-end쪽에 id로 검색해서 데이터를 삭제하도록 요청
      TutorialDataService.delete(this.currentTutorial.id)
          // *성공하면 then으로
          .then(response => {
            console.log(response.data)
            // *tutorials 새로고침 => router '/tutorials'으로 이동함 => 즉 TutorialList.vue로 이동
            this.$router.push({ name: 'tutorials' })
          })
          // *실패하면 then으로
          .catch(e => {
            console.log(e)
          })
    },
    // tutorial 테이블 published 컬럼 : 'Y' <=> 'N' 메소드
    updatePublished (status) {
      // TODO => 다음에 천천히 작성하도록
    },
  },
  // vue 화면이 로딩될때(뜰때) 자동으로 실행되는 이벤트
  mounted () {
    this.message = ''
    // *router/index.js => path: '/tutorials/:id'
    this.getTutorial(this.$route.params.id)
  },
}
</script>

<style scoped>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>