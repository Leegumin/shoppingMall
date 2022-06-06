<template>
  <!-- Navigation-->
  <nav class = "navbar navbar-expand-lg navbar-light bg-light">
    <div class = "container px-4 px-lg-5">
      <a class = "navbar-brand"
         href = "#!"
      >NOSINSA</a>
      <button class = "navbar-toggler"
              type = "button"
              data-bs-toggle = "collapse"
              data-bs-target = "#navbarSupportedContent"
              aria-controls = "navbarSupportedContent"
              aria-expanded = "false"
              aria-label = "Toggle navigation"
      ><span class = "navbar-toggler-icon"></span></button>
      <div class = "collapse navbar-collapse"
           id = "navbarSupportedContent"
      >
        <ul class = "navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
          <!-- * home 시작-->
          <li class = "nav-item">
            <router-link to = "/home"
                         class = "nav-link active"
                         aria-current = "page"
            >Home
            </router-link>
          </li>
          <!-- * home 끝-->
          <!-- * dropdown #1 시작-->
          <li class = "nav-item dropdown">
            <a class = "nav-link dropdown-toggle"
               id = "navbarDropdown"
               href = "#"
               role = "button"
               data-bs-toggle = "dropdown"
               aria-expanded = "false"
            >Shop</a>
            <ul class = "dropdown-menu"
                aria-labelledby = "navbarDropdown"
            >
              <li><a class = "dropdown-item"
                     href = "#!"
              >All Products</a></li>
              <li>
                <hr class = "dropdown-divider"/>
              </li>
              <li><a class = "dropdown-item"
                     href = "#!"
              >Popular Items</a></li>
              <li><a class = "dropdown-item"
                     href = "#!"
              >New Arrivals</a></li>
            </ul>
          </li>
          <!-- * dropdown #1 끝-->
          <!-- * dropdown #2 시작-->
<!--          <li class = "nav-item dropdown">
            <a class = "nav-link dropdown-toggle"
               id = "navbarDropdown"
               href = "#"
               role = "button"
               data-bs-toggle = "dropdown"
               aria-expanded = "false"
            >Tutorial Menu</a>
            <ul class = "dropdown-menu"
                aria-labelledby = "navbarDropdown"
            >
              <router-link to = "/tutorials"
                           class = "dropdown-item"
              >Tutorials
              </router-link>
              <router-link to = "/add"
                           class = "dropdown-item"
              >Add
              </router-link>
              <router-link to = "/upload"
                           class = "dropdown-item"
              >Upload Image
              </router-link>
            </ul>
          </li>-->
          <!-- * dropdown #2 끝-->
          <!-- * 회원가입 시작-->
          <li class = "nav-item">
            <router-link to = "/register"
                         class = "nav-link active"
                         aria-current = "page"
            >Register
            </router-link>
          </li>
          <!-- * 회원가입 끝-->
        </ul>
        <!--* 검색창 시작-->
        <form class = "d-flex me-2">
          <input class = "form-control me-0"
                 type = "search"
                 placeholder = "Search"
                 aria-label = "Search"
          >
          <button class = "btn btn-outline-dark"
                  type = "submit"
          ><i class = "fa fa-search"
              aria-hidden = "true"
          ></i>
          </button>
        </form>
        <!--* 검색창 끝-->
        <form class = "d-flex ">
          <button class = "btn btn-outline-dark "
                  type = "submit"
          >
            <i class = "bi-cart-fill me-1"></i>
            Cart
            <span class = "badge bg-dark text-white ms-1 rounded-pill">0</span>
          </button>
        </form>
      </div>
    </div>
  </nav>
</template>

<script>
export default {}
</script>

<style>
</style>