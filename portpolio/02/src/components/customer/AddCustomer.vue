<template>
  <div class="container mt-3">
    <!--새 회원가입일 경우 submitted = false -->
    <div v-if = "!submitted">
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
               v-model = "customer.firstName"
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
               v-model = "customer.lastName"
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
               v-model = "customer.email"
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
               v-model = "customer.phone"
        >
      </div>
      <!--*div mb-3 #4 끝-->
      <div class = "mb-3">
        <button @click = "saveCustomer"
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
        Save customer successfully!
      </div>
      <button @click = "newCustomer"
              class = "btn btn-primary"
      >
        Add New Customer
      </button>
    </div>
  </div>
</template>

<script>
import CustomerDataService from '@/services/CustomerDataService'

export default {
  name: 'add-customer',
  data () {
    // 객체, 변수 초기화
    return {
      customer : {
        id       : null,
        firstName: '',
        lastName : '',
        email    : '',
        phone    : '',
      },
      submitted: false,
    }
  },
  methods: {
    // 저장 메소드 호출
    saveCustomer () {
      // 회원 임시 객체 만들기
      var data = {
        firstName: this.customer.firstName,
        lastName : this.customer.lastName,
        email    : this.customer.email,
        phone    : this.customer.phone,
      }
      // 임시 회원 객체를 서버쪽으로 전달해서 DB에 insert 요청
      CustomerDataService.create(data)
          // 성공하면 then
          .then(response => {
            this.customer.id = response.data.id
            this.submitted = true // DB insert 성공
          })
          // 실패하면 catch
          .catch(e => {
            alert(e)
          })
    },
    // 새 회원가입을 위한 빈 form을 만드는 메소드 (변수 초기화)
    newCustomer () {
      this.submitted = false
      this.customer = {}
    },
  },
}
</script>

<style scoped>

</style>