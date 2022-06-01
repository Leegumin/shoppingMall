<template>
<div>
  <h3>{{ title }}</h3>

  <ul class="white">
    <li>
      <router-link to="/admin/list">제품 리스트(Product List)</router-link>
    </li>
    <li>
      <router-link to="/admin/insert">제품 추가(New Product)</router-link>
    </li>
    <!-- 자식 라우터 -> 라우터 링크를 클릭하면 출력되는 부분-->
    <router-view></router-view>
  </ul>
</div>
</template>

<script>
// @ is an alias to /src

export default {
  data(){
    return{
      title: "Admin 페이지입니다."
    }
  },
  // 라우터를 들어갈 때
  beforeRouteEnter(to, from, next) {
    console.log(`beforeRouteEnter: to: ${to}, from: ${from}`);
    next();
  },

  // 라우터를 나갈 때
  beforeRouteLeave(to, from, next) {
    console.log(`beforeRouteLeave: to: ${to}, from: ${from}`);
    next();
  },
}
</script>

<style>
li {
  display: inline-block;
  padding: 5px;
}

li a{
  font-weight: bold;
  color: black;
}
  
</style>