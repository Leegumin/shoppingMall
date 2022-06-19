<template>
  <div class = "submit-form">

    <div v-if = "!submitted">
      <div class = "form-group">
        <label for = "title">Title</label>
        <input type = "text" class = "form-control" id = "title" required v-model = "tutorial.title" name = "title">
      </div>

      <div class = "form-group">
        <label for = "description">Description</label>
        <input type = "text" class = "form-control" id = "description" required v-model = "tutorial.description"
               name = "description"
        >
      </div>
      <button class = "btn btn-success" @click = "saveTutorial">Submit</button>
    </div>
    <div v-else>
      <h4>You submitted successfully!</h4>
      <button class = "btn btn-success" @click = "newTutorial">Add</button>
    </div>
  </div>
</template>

<script>
  // 화면 : Tutorial 데이터 추가하는 화면
  import TutorialDataService from '../services/TutorialDataService'

export default {
  name: 'add-tutorial',
  data () {
    return {
      // tutorial 객체 초기화
      tutorial : {
        id         : null,
        title      : '',
        description: '',
        published  : 'N',
      },
      submitted: false,
    }
  },
  methods: {
    saveTutorial () {
      // *전송용 데이터 정의 whrer? => springboot
      var data = {
        title      : this.tutorial.title,
        description: this.tutorial.description,
      }
      // *springboot(api서버)에 현재 정의된 데이터를 추가하는 요청
      TutorialDataService.create(data)
          //요청이 성공하면 결과가 들어옴
          .then(response => {
            this.tutorial.id = response.data.id
            this.submitted = true
            console.log(response.data)
            //요청이 실패하면 결과가 들어옴
          }).catch(e => {
        console.log(e)
      })
    },
    newTutorial () {
      this.submitted = false
      this.tutorial = {}
    }
    ,
  },

}
</script>

<style scoped>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>