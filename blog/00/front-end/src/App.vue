<!-- * App.vue = 최상위 부모 -->

<template>
  <div id = "app">
    <!-- * bootstrap dropdown 적용 -->
    <nav class = "navbar navbar-expand-lg navbar-dark bg-dark small sticky-top">
      <!--      <a class="navbar-brand" href="#">Navbar</a>-->
      <a class = "navbar-brand"
         href = "#"
      >
        <img src = "@/assets/img/heart.png"
             width = "30"
             height = "30"
             alt = ""
        >
      </a>
      <button class = "navbar-toggler"
              type = "button"
              data-toggle = "collapse"
              data-target = "#navbarNavDropdown"
              aria-controls = "navbarNavDropdown"
              aria-expanded = "false"
              aria-label = "Toggle navigation"
      >
        <span class = "navbar-toggler-icon"></span>
      </button>
      <div class = "collapse navbar-collapse"
           id = "navbarNavDropdown"
      >
        <ul class = "navbar-nav">
          <!-- * dropdown #1 -->
          <li class = "nav-item dropdown mr-4 active">
            <a class = "nav-link dropdown-toggle"
               href = "#"
               id = "navbarDropdownMenuLink"
               data-toggle = "dropdown"
               aria-haspopup = "true"
               aria-expanded = "false"
            >
              About
            </a>
            <div class = "dropdown-menu"
                 aria-labelledby = "navbarDropdownMenuLink"
            >
              <router-link to = "/home"
                           class = "dropdown-item"
              >
                Home
              </router-link>
            </div>
          </li>
          <!-- * dropdown #2 -->
          <li class = "nav-item dropdown mr-4 active">
            <a class = "nav-link dropdown-toggle"
               href = "#"
               id = "navbarDropdownMenuLink"
               data-toggle = "dropdown"
               aria-haspopup = "true"
               aria-expanded = "false"
            >
              Tutorial Menu
            </a>
            <div class = "dropdown-menu"
                 aria-labelledby = "navbarDropdownMenuLink"
            >
              <router-link to = "/tutorials"
                           class = "dropdown-item"
              >
                Tutorials
              </router-link>
              <router-link to = "/add"
                           class = "dropdown-item"
              >
                Add
              </router-link>
              <router-link to = "/upload"
                           class = "dropdown-item"
              >
                Upload Image
              </router-link>
            </div>
          </li>
          <!-- * dropdown #3 -->
          <li class = "nav-item dropdown mr-4 active">
            <a class = "nav-link dropdown-toggle"
               href = "#"
               id = "navbarDropdownMenuLink"
               data-toggle = "dropdown"
               aria-haspopup = "true"
               aria-expanded = "false"
            >
              Customer Manager
            </a>
            <div class = "dropdown-menu"
                 aria-labelledby = "navbarDropdownMenuLink"
            >
              <router-link to = "/customers"
                           class = "dropdown-item"
              >
                Customer List
              </router-link>
              <router-link to = "/customers/add"
                           class = "dropdown-item"
              >
                Add New Customer
              </router-link>
            </div>
          </li>
          <!-- * dropdown #4 -->
          <li class = "nav-item dropdown mr-4 active">
            <a class = "nav-link dropdown-toggle"
               href = "#"
               id = "navbarDropdownMenuLink"
               data-toggle = "dropdown"
               aria-haspopup = "true"
               aria-expanded = "false"
            >
              Complain Manager
            </a>
            <div class = "dropdown-menu"
                 aria-labelledby = "navbarDropdownMenuLink"
            >
              <router-link to = "/complains"
                           class = "dropdown-item"
              >
                Complain List
              </router-link>
              <router-link to = "/complains/add"
                           class = "dropdown-item"
              >
                Add New Complain
              </router-link>
            </div>
          </li>
          <!-- * dropdown #5 -->
          <li class = "nav-item dropdown mr-4 active">
            <a class = "nav-link dropdown-toggle"
               href = "#"
               id = "navbarDropdownMenuLink"
               data-toggle = "dropdown"
               aria-haspopup = "true"
               aria-expanded = "false"
            >
              자유게시판
            </a>
            <div class = "dropdown-menu"
                 aria-labelledby = "navbarDropdownMenuLink"
            >
              <router-link to = "/free-boards"
                           class = "dropdown-item"
              >
                자유게시판 목록
              </router-link>
              <router-link to = "/free-boards/add"
                           class = "dropdown-item"
              >
                글쓰기
              </router-link>
            </div>
          </li>
          <!-- * dropdown #6 -->
          <li class = "nav-item dropdown mr-4 active">
            <a class = "nav-link dropdown-toggle"
               href = "#"
               id = "navbarDropdownMenuLink"
               data-toggle = "dropdown"
               aria-haspopup = "true"
               aria-expanded = "false"
            >
              FAQ게시판
            </a>
            <div class = "dropdown-menu"
                 aria-labelledby = "navbarDropdownMenuLink"
            >
              <router-link to = "/faq-boards"
                           class = "dropdown-item"
              >
                FAQ 목록
              </router-link>
              <router-link to = "/faq-boards/add"
                           class = "dropdown-item"
              >
                FAQ 글쓰기
              </router-link>
            </div>
          </li>
        </ul>
      </div>
    </nav>
    <!--<div class = "container mt-3">-->
    <!-- 위의 router-link에 있는 메뉴 화면이 아래 위치에 표시 -->
    <router-view></router-view>
    <!--</div>-->
  </div>
</template>

<script>
export default {}
</script>

<style>

</style>
