<template>
  <div id = "app">
    <!--nav 시작-->
    <nav class = "navbar navbar-expand navbar-dark bg-dark">
      <router-link to = "/" class = "navbar-brand">bezkoder</router-link>
      <!--div 시작-->
      <div class = "navbar-nav mr-auto">
        <li class = "nav-item">
          <router-link to = "/tutorials" class = "nav-link">
            Tutorials
          </router-link>
        </li>
        <li class = "nav-item">
          <router-link to = "/add" class = "nav-link">
            Add
          </router-link>
        </li>
      </div>
      <!--div 끝-->
    </nav>
    <!--nav끝-->
    <div class = "container mt-3">
      <!--*router-view : 위의 router-link 있는 메뉴 화면이 아래 위치에 표시됨-->
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
}
</script>
<style>
</style>
