<!-- * App.vue = 최상위 부모 -->

<template>
  <div id = "app">
    <!-- * bootstrap dropdown 적용 -->
    <!--p(padding), m(margin)/l(left), r(right), t(top), b(bottom)-1~5-->
    <!--<div class = "container mt-3">-->
    <!-- 위의 router-link에 있는 메뉴 화면이 아래 위치에 표시 -->
    <router-view></router-view>
    <!--</div>-->
  </div>
</template>

<script>
export default {
  components: {
  }
}
</script>

<style>

</style>
