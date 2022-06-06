<!-- * App.vue = 최상위 부모 -->
<template>
  <div id = "app">
    <!--네브바-->
    <NavCom></NavCom>
    <!--헤더-->
    <HeaderCom></HeaderCom>
    <!--사이드바, 푸터-->
    <!--메인-->
    <!--router-link 표시 위치 -->
    <router-view></router-view>
    <FooterCom></FooterCom>
  </div>
</template>

<script>
import NavCom from '@/components/common/NavCom.vue'
import HeaderCom from '@/components/common/HeaderCom.vue'
import FooterCom from '@/components/common/FooterCom.vue'

export default {
  components:
      {
        HeaderCom,
        NavCom,
        FooterCom,
      },
}
</script>

<style>
</style>
