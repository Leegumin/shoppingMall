<!-- * App.vue = 최상위 부모 -->
<template>
  <div id = "app">
    <!--헤더-->
    <HeaderCom></HeaderCom>
    <!--?네비바-->
    <header class = "navbar navbar-expand navbar-dark bg-dark bd-navbar">

      <div class = "container mt-3">
        <!--네브바-->
        <NavCom></NavCom>
      </div>

      <a class = "navbar-brand"
         href = "#"
      >Menu</a>
      <button class = "navbar-toggler"
              type = "button"
              data-toggle = "collapse"
              data-target = "#navbarNav"
              aria-controls = "navbarNav"
              aria-expanded = "false"
              aria-label = "Toggle navigation"
      >
        <span class = "navbar-toggler-icon"></span>
      </button>
      <div class = "collapse navbar-collapse"
           id = "navbarNav"
      >
        <ul class = "navbar-nav">
          <li class = "nav-item active"><a class = "nav-link"
                                           href = "#"
          >홈</a></li>
          <li class = "nav-item"><a class = "nav-link"
                                    href = "#"
          >1번 메뉴</a></li>
          <li class = "nav-item"><a class = "nav-link"
                                    href = "#"
          >2번 메뉴</a></li>
        </ul>
      </div>
    </header>
    <!--?사이드바-->
    <div class = "container-fluid">
      <div class = "row flex-nowrap">
        <SideBar></SideBar>
        <!--?메인-->
        <main class = "col-9 py-md-3 pl-md-5 bd-content"
              role = "main"
        >
          <!-- 위의 router-link에 있는 메뉴 화면이 아래 위치에 표시 -->
          <router-view></router-view>
          <!--푸터-->
          <FooterCom></FooterCom>
        </main>
      </div>
    </div>
  </div>
</template>

<script>
import NavCom from '@/components/common/NavCom.vue'
import HeaderCom from '@/components/common/HeaderCom.vue'
import FooterCom from '@/components/common/FooterCom'
import SideBar from '@/components/common/SideBar'

export default {
  components:
      {
        HeaderCom,
        NavCom,
        FooterCom,
        SideBar,
      },
}
</script>

<style>
.bd-navbar {
  position: sticky;
  top: 0;
  z-index: 1071;
  min-height: 4rem;
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, .05), inset 0 -1px 0 rgba(0, 0, 0, .1);
}

.bd-sidebar {
  position: sticky;
  top: 4rem;
  z-index: 1000;
  height: calc(100vh - 4rem);
  background: #eee;
  border-right: 1px solid rgba(0, 0, 0, .1);
  overflow-y: auto;
  min-width: 160px;
  max-width: 220px;
}

.bd-sidebar .nav {
  display: block;
}

.bd-sidebar .nav > li > a {
  display: block;
  padding: .25rem 1.5rem;
  font-size: 90%;
}
</style>
