<!-- * App.vue = 최상위 부모 -->

<template>
  <div id = "app">
    <NavView></NavView>
    <!--<div class = "container mt-3">-->
    <!-- 위의 router-link에 있는 메뉴 화면이 아래 위치에 표시 -->
    <router-view></router-view>
    <!--</div>-->
  </div>
</template>

<script>
import NavView from '@/views/NavView'

export default {
  components: {
    NavView,
  },
}
</script>

<style>

</style>
