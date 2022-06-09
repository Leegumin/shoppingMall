<template>
  <div class="container mt-3">
    <table class = "table">
      <thead>
      <tr>
        <th scope = "col">First Name</th>
        <th scope = "col">Last Name</th>
        <th scope = "col">Email</th>
        <th scope = "col">Phone</th>
        <th scope = "col">Actions</th>
      </tr>
      </thead>
      <!--#조회 데이터 생 부분-->
      <tbody v-for = "(customer, index) in cunstomers"
             :key = "index"
      >
      <tr>
        <td>{{ customer.firstName }}</td>
        <td>{{ customer.lastName }}</td>
        <td>{{ customer.email }}</td>
        <td>{{ customer.phone }}</td>
        <!--* http://localhost8080/customers/customer.id 형태의 주소로 이동-->
        <!--* :href -> v-bind:href, customer.id 값을 가져오기 위해서는 <script>의 data()와 바인딩할 필요가 있음-->
        <td><a :href = "'/customers/' + customer.id"
               class = "btn btn-primary"
        >Edit</a></td>
      </tr>
      </tbody>
    </table>

  </div>
</template>

<script>
import CustomerDataService from '@/services/CustomerDataService'

export default {
  // eslint-disable-next-line
  name: 'customers',
  data () {
    return {
      cunstomers: [],
    }
  },
  methods: {
    // 모든 회원 조회 서비스 호출
    retrieveCustomers () {
      // axios로 spring에 모든 회원 조회 요청
      CustomerDataService.getAll()
          // 성공하면 then으로 서버(spring) 데이터(response.data)가 들어옴
          .then(response => {
            this.cunstomers = response.data
          }).catch(e => {
        alert(e)
      })
    },
  },
  // 화면이 뜨자마자 실행되는 이벤트
  mounted () {
    // 모든 회원 조회 메서드 실행
    this.retrieveCustomers()
  },
}
</script>

<style scoped>
</style>