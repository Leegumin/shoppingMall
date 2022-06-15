<template>
  <!-- Header-->
  <header class = "masthead d-flex align-items-center">
    <div class = "container px-4 px-lg-5 text-center">
      <h1 class = "mb-1">안녕하세요 이구민입니다.</h1>
      <br>
      <h3 class = "mb-5">국비지원과정 교육 Java(자바)기반 웹 융합 풀스택 개발자(프런트엔드/백엔드) 과정을 수료했습니다.</h3>
      <h3 class = "mb-5">비전공자에 실력도 아직은 햇병아리지만, 오히려 그렇기 때문에 색칠하기 좋은 신입 지원자입니다.</h3>
      <h3 class = "mb-5">언제든 배울 각오가 돼있으며, 쓰임을 다 할 준비가 돼있습니다.</h3>
      <a class = "btn btn-primary btn-xl"
         href = "#about"
      >Find Out More</a>
    </div>
  </header>
</template>

<script>
export default {
  name: 'HeaderCom',
}
</script>

<style scoped>
.masthead {
  background: linear-gradient(90deg, rgba(255, 255, 255, 0.3) 0%, rgba(255, 255, 255, 0.2) 100%), url("@/assets/img/hd-wallpaper-1867616_1920.jpg");
  background-position: center center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>