<!-- * App.vue = 최상위 부모 -->
<template>
  <div id = "app">
    <!--헤더-->
    <!--<HeaderCom></HeaderCom>-->
    <!--네브바-->
    <NavCom></NavCom>
    <!--사이드바, 푸터-->
    <div class = "container-fluid">
      <div class = "row flex-nowrap">
<!--        <SideBar></SideBar>-->
        <!--메인-->
        <main class = "col-9 py-md-3 pl-md-5 bd-content"
              role = "main"
        >
          <!--router-link 표시 위치 -->
          <router-view></router-view>
        </main>
      </div>
    </div>
  </div>
</template>

<script>
import NavCom from '@/components/common/NavCom.vue'
// import HeaderCom from '@/components/common/HeaderCom.vue'
// import SideBar from '@/components/common/SideBar_Footer'

export default {
  components:
      {
        // HeaderCom,
        NavCom,
        // SideBar,
      },
}
</script>

<style>
</style>
