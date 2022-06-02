<template>
  <div class = "list row">

    <!--search 관련 div 시작-->
    <div class = "col-md-8">
      <div class = "input-group mb-3">
        <!--검색 입력 박스-->
        <input type = "text"
               class = "form-control"
               placeholder = "Search by title"
               v-model = "title"
        >
        <!--검색 버튼-->
        <div class = "input-group-append">
          <button class = "btn btn-outline-secondary"
                  type = "button"
                  @click = "searchTitle"
          >
            Search
          </button>
        </div>
      </div>
    </div>
    <!--search 관련 div 끝-->


    <!--목록을 보여주는 div 시작-->
    <div class = "col-md-6">
      <h4>Tutorials List</h4>
      <!--제목 목록-->
      <ul class = "list-group">
        <li class = "list-group-item"
            :class = "{ active: index == currentIndex}"
            v-for = "(tutorial, index) in tutorials"
            :key = "index"
            @click = "setActiveTutorial(tutorial,index)"
        >
          {{ tutorial.title }}
        </li>
      </ul>
      <!--모든 목록 삭제 버튼-->
      <button class = "m-3 btn btn-sm btn-danger"
              @click = "removeAllTutorials"
      >Remove All
      </button>
    </div>
    <!--목록을 보여주는 div 끝-->

    <!--상세 정보를 보여주는 div 시작-->
    <div class = "col-md-6">
      <!--currentTutorial != null 이면 -->
      <div v-if = "currentTutorial">
        <h4>Tutorial</h4>
        <div>
          <label><strong>Title: {{ currentTutorial.title }}</strong></label>
        </div>

        <div>
          <label><strong>Description: {{ currentTutorial.description }}</strong></label>
        </div>

        <div>
          <label><strong>Status: {{ currentTutorial.published == 'Y' ? 'Published' : 'Pending' }}</strong></label>
        </div>
        <!--link 추가-->
        <router-link :to = "'/tutorials/' + currentTutorial.id"
                     class = "badge badge-primary"
        >
          Edit
        </router-link>
      </div>
      <!--currentTutorial == null 이면 -->
      <div v-else>
        <br>
        <p>Please click on a Tutorial...</p>
      </div>
    </div>
    <!--상세 정보를 보여주는 div 끝-->
  </div>

</template>

<script>
// 화면 : Tutorial 데이터 추가하는 화면
import TutorialDataService from '../services/TutorialDataService'

export default {
  name: 'tutorials-list',
  data () {
    // tutorials 배열 객체, 변수들 초기화
    return {
      tutorials      : [],
      currentTutorial: null,
      currentIndex   : -1,
      title          : '',
    }
  },
  methods: {
    // *retrieve : 검색하다
    retrieveTutorials () {
      // back-end(스프링)으로 전체 데이터를 요청
      TutorialDataService.getAll()
          // 성공하면 then으로 들어옴
          // *response : 헤더(상태정보, 쿠키 등), 바디(json) 등을 포함하고 있음
          // *data : back-end(스프링)에서 보내준 tutorial 객체가 담김
          // *.then(매개변수이름 => { : 매개변수 이름 굳이 response가 아니라도 상관없음. then에서 매개변수로 들어오면 response
          // *역할을 한다는 것을 직관적으로 나타내주기 위해 response로 매개변수 이름을 정한 것일 뿐임.
          .then(response => {
            // *back-end(스프링)에서 같은 주소를 가진 메서드 실행시 성공하면 보내주는 데이터를 받아옴
            this.tutorials = response.data
            // *데이터가 잘 들어왔는지 로그 확인
            console.log(response.data)
          })
          // 실패하면 에러 출력
          .catch(e => {
            console.log(e)
          })
    },
    // 목록 삭제 후 화면 다시 로딩할때 사용하는 메소드
    // 새로고침 메소드
    refreshList () {
      this.currentTutorial = null
      this.currentIndex = -1
      this.retrieveTutorials()
    },
    // vue의 data 변수에 값을 저장하는 메소드(클릭했을 때 현재값 저장)
    setActiveTutorial (tutorial, index) {
      this.currentTutorial = tutorial
      this.currentIndex = index
    },
    // 모든 목록 삭제 메소드
    removeAllTutorials () {
      // back-end(spring) 쪽으로 전체데이터 삭제 요청
      TutorialDataService.deleteAll()
          // *성공하면 then으로 들어옴
          .then(response => {
            console.log(response.data)
            // 모든 데이터를 삭제했으므로 새로고침 메소드를 실행
            this.refreshList()
          })
          // *실패하면 catch으로 들어옴
          .catch(e => {
            console.log(e)
          })
    },
    // 제목검색을 위한 메소드
    searchTitle () {
      // back-end(spring)쪽으로 제목(title) 데이터를 요청
      TutorialDataService.findByTitle(this.title)
          // *성공하면 then으로 들어옴
          .then(response => {
            // *back-end(spring)쪽에서 받은 데이터를 vue의 data변수(tutorials)에 넣음
            this.tutorials = response.data
            console.log(response.data)
          })
          // *실패하면 catch으로 들어옴
          .catch(e => {
            console.log(e)
          })
    },
  },
  // 최초 화면이 로딩될때(뜰때) 실행되는 이벤트
  mounted () {
    // 전체 목록 가져오기 메소드 호출
    this.retrieveTutorials()
  },
}
</script>

<style scoped>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>