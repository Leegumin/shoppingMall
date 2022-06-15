<template>
  <div class="container mt-3">
    <div class = "row">
      <div class = "col-8">
        <label class = "btn btn-default p-0"
        >
          <!--파일 선택상자-->
          <input type = "file"
                 accept = "image/*"
                 ref = "file"
                 @change = "selectImage"
          >
        </label>
      </div>
      <div class = "col-4">
        <!--서버에 insert문 호출-->
        <button class = "btn btn-success btn-sm float-right"
                :disabled = "!currentImage"
                @click = "upload"
        >
          Upload
        </button>
      </div>
    </div>

    <!--프로그래스 바 시작-->
    <div v-if = "currentImage"
         class = "progress"
    >
      <div class = "progress-bar progress-bar-info"
           role = "progressbar"
           :style = "{width: progress + '%'}"
           :aria-valuenow = "progress"
           aria-valuemin = "0"
           aria-valuemax = "100"
      >
        {{ progress }}%
      </div>
    </div>
    <!--프로그래스 바 끝-->
    <!--미리보기 이미지 시작-->
    <div v-if = "previewImage">
      <div>
        <img class = "preview my-3"
             :src = "previewImage"
             alt = ""
        >
      </div>
    </div>
    <!--미리보기 이미지 끝-->
    <!--서버에러 메시지가 있을 경우 시작-->
    <div v-if = "message"
         class = "alert alert-secondary"
         role = "alert"
    >
      {{ message }}
    </div>
    <!--서버에러 메시지가 있을 경우 끝-->

    <!-- list(목록) 이미지 정보를 출력, 쇼핑카트 형태 디자인-->
    <div class = "card mt-3"
         v-for = "(image, index) in imageInfo"
         :key = "index"
    >
      <div class = "card-header">이미지 번호 : {{ image.id }}</div>
      <div class = "row">
        <div class = "col-md-5 col-md-offset-0">
          <figure>
            <img
                class = "img-thumbnail"
                :src = "image.url"
                alt = "이미지 없음"
            />
          </figure>
        </div>
        <div class = "col-md-6 col-md-offset-0 description">
          <p v-html = "image.name"></p>
          <p class = "price">
            {{ image.url }}
          </p>
        </div>
      </div>
    </div>
    <!--<div class = "card mt-3">-->
    <!--  <div class = "card-header">List of Image</div>-->
    <!--  <ul class = "list-group list-group-flush">-->
    <!--    <li class = "list-group-item"-->
    <!--        v-for = "(image, index) in imageInfo"-->
    <!--        :key = "index"-->
    <!--    ><a :href = "image.url">{{ image.name }}</a>-->
    <!--    </li>-->
    <!--  </ul>-->
    <!--</div>-->
  </div>
</template>

<script>
import UploadFilesService from '@/services/UploadFilesService'

export default {
  name: 'upload-image',
  data () {
    return {
      currentImage: undefined,  // 현재이미지
      previewImage: undefined,  // 미리보기 이미지
      progress    : 0,          // 프로그래스바를 위한 변수
      message     : '',         // 메세지
      imageInfo   : [],         // 이미지 정보 객체배열
    }
  },
  methods: {
    // 이미지를 선택하면 변수에 저장하는 메소드
    selectImage () {
      // $refs: vue에서 html의 태그 정보에 접근할 수 있음
      // 파일 선택상자에서 첫번째로 선택한 이미지가 저장됨
      this.currentImage = this.$refs.file.files.item(0)
      // 데이터의 주소만 찾아가서 미리보기 이미지를 띄우는 기능(주소만 저장됨)
      this.previewImage = URL.createObjectURL(this.currentImage)

      this.progress = 0
      this.message = ''
    },
    // 파일 업로드를 위한 메소드
    upload () {
      this.progress = 0
      // 서버에 이미지 업로드 요청 -> insert문 실행
      UploadFilesService.upload(this.currentImage, (event) => {
        // 파일이 업로드 될 때 진척상황이 저장 됨(%)
        this.progress = Math.round((100 * event.loaded) / event.total)
      })
          // 성공하면 then(서버에서 응답한 객체)
          .then(response => {
            // 서버쪽 응답 메시지 저장
            this.message = response.data.message
            // 서버쪽에 insert가 잘 됐는지 select문 호출
            return UploadFilesService.getFiles()
          })
          // return UploadFilesService.getFiles() -> 이 코드 때문에 또 than이 나옴
          // 성공하면 then(서버쪽 객체 받음)
          .then(image => {
            this.imageInfo = image.data
          })
          // 실패하면 catch, 화면에 실패메세지 출력
          .catch(err => {
            this.progress = 0
            this.message = 'Could not upload the image!' + err
            this.currentImage = undefined
          })
    },
  },
  // 화면이 뜨자마자 실행되는 이벤트
  mounted () {
    UploadFilesService.getFiles()
        // *성공하면 then(객체, 응답메세지)
        .then(response => {
          // response.data : 서버쪽에서 전성된 객체
          this.imageInfo = response.data
        })
  },
}
</script>

<style scoped>
.preview {
  max-width: 200px;
}
</style>