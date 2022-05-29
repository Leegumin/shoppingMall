<template>
  <div id="app">
    <!-- <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/complain">Complain</router-link> |
      <router-link to="/infocup">info_cup</router-link>
    </nav> -->

    <!-- 공통으로 쓰는건 여기에 전부 추가 -->
    <HeaderCom></HeaderCom>
    <NavCom></NavCom>
    <!-- 컨텐츠가 바뀌는 부분(router/index.js 에서 자동으로 처리) -->
    <router-view />
    <FooterCom></FooterCom>
  </div>
</template>

<script>
import HeaderCom from "@/components/common/HeaderCom.vue";
import NavCom from "@/components/common/NavCom.vue";
import FooterCom from "@/components/common/FooterCom.vue";

export default {
  components: {
    HeaderCom,
    NavCom,
    FooterCom,
  },
};
</script>
<style>
</style>
