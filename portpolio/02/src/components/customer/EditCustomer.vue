<template>
  <!--기존 회원이 있을 경우 currentCustomer != null이 아닐 경우, 현재 상태는 currentCustomer null-->
  <div v-if = "currentCustomer" class="container mt-3">
    <!--! mb-3 : m(margin), p(padding), : l(left), r(right), b(bottom), 1 : 25px ~ -->
    <!--*div mb-3 #1 시작-->
    <div class = "mb-3">
      <label for = "firstName"
             class = "form-label"
      >
        First Name
      </label>
      <input type = "text"
             class = "form-control"
             id = "firstName"
             required
             name = "firstName"
             v-model = "currentCustomer.firstName"
      >
    </div>
    <!--*div mb-3 #1 끝-->
    <!--*div mb-3 #2 시작-->
    <div class = "mb-3">
      <label for = "firstName"
             class = "form-label"
      >
        Last Name
      </label>
      <input type = "text"
             class = "form-control"
             id = "lastName"
             required
             name = "lastName"
             v-model = "currentCustomer.lastName"
      >
    </div>
    <!--*div mb-3 #2 끝-->
    <!--*div mb-3 #3 시작-->
    <div class = "mb-3">
      <label for = "lastName"
             class = "form-label"
      >
        Email
      </label>
      <input type = "email"
             class = "form-control"
             id = "email"
             required
             name = "email"
             v-model = "currentCustomer.email"
      >
    </div>
    <!--*div mb-3 #3 끝-->
    <!--*div mb-3 #4 시작-->
    <div class = "mb-3">
      <label for = "email"
             class = "form-label"
      >
        Phone
      </label>
      <input type = "text"
             class = "form-control"
             id = "phone"
             required
             name = "phone"
             v-model = "currentCustomer.phone"
      >
    </div>
    <!--*div mb-3 #4 끝-->
    <div class = "mb-3">
      <button @click = "updateCustomer"
              class = "btn btn-primary me-3"
      >Update
      </button>
      <button @click = "deleteCustomer"
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
import CustomerDataService from '@/services/CustomerDataService'

export default {
  name: 'edit-customer',
  data () {
    return {
      currentCustomer: null,
      message        : '',
    }
  },
  methods: {
    // id에 해당하는 회원정보를 조회하는 서비스 요청
    getCustomer (id) {
      CustomerDataService.get(id)
          // * 성공하면 then ( 결과데이터 response.data가 들어옴 )
          .then(response => {
            this.currentCustomer = response.data
          })
          // * 실패하면 catch
          .catch(e => {
            alert(e)
          })
    },
    // 회원정보 수정 서비스 요청
    updateCustomer () {
      CustomerDataService.update(this.currentCustomer.id, this.currentCustomer)
          // * 성공하면 then
          .then(response => {
            console.log(response.data)
            this.message = 'The Customer was updated successfully!'
          })
          // * 실패하면 catch
          .catch(e => {
            alert(e)
          })
    },
    // 회원 삭제 서비스 요청
    deleteCustomer () {
      CustomerDataService.delete(this.currentCustomer.id)
          // * 성공하면 then
          .then(response => {
            console.log(response.data)
            // * 회원정보 삭제 후 회원정보 전체 리스트가 있는 곳으로 이동
            // * $router.push에 관한 설명은 아래 참고
            // * https://router.vuejs.org/guide/essentials/navigation.html#navigate-to-a-different-location
            // * index.js의 name으로 지정하는 방식(Json 형태로 데이터 기입)
            this.$router.push({ name: 'customers' })
            // * url로 지정하는 방식
            // this.$router.push('/customers')
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
    this.getCustomer(this.$route.params.id)
  },
}
</script>

<style scoped>

</style>