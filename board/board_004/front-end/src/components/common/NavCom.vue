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
            <!--?active 보류-->
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
              <router-link to = "#"
                           class = "dropdown-item"
              >All Products
              </router-link>
              <li>
                <hr class = "dropdown-divider"/>
              </li>
              <router-link to = "#"
                           class = "dropdown-item"
              >Popular Items
              </router-link>
              <router-link to = "#"
                           class = "dropdown-item"
              >Sale Items
              </router-link>
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
        </ul>
        <!--* 검색창 시작-->
        <form class = "d-flex me-2">
          <input class = "form-control me-0 btn-outline-dark"
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
        <!--* 고객 기능 시작-->
        <form class = "d-flex me-2 dropdown">
          <button class = "btn btn-outline-dark"
                  type = "button"
          >
            <!--* 드롭다운메뉴 시작-->
            <div class = "navbar-nav">
              <ul class = "navbar-nav">
                <li>
                  <div id = "navbarDropdown"
                       href = "#"
                       role = "button"
                       data-bs-toggle = "dropdown"
                       aria-expanded = "false"
                  ><i class = "fa fa-user-circle-o"
                      aria-hidden = "true"
                  ></i>
                  </div>
                  <ul class = "dropdown-menu"
                      aria-labelledby = "navbarDropdown"
                  >
                    <router-link to = "/login"
                                 class = "dropdown-item"
                    >Login
                    </router-link>
                    <router-link to = "#"
                                 class = "dropdown-item"
                    >Register
                    </router-link>
                    <router-link to = "#"
                                 class = "dropdown-item"
                    >MyPage
                    </router-link>
                    <router-link to = "#"
                                 class = "dropdown-item"
                    >WishList
                    </router-link>
                    <router-link to = "#"
                                 class = "dropdown-item"
                    >Question
                    </router-link>
                  </ul>
                </li>
              </ul>
            </div>
            <!--* 드롭다운메뉴 끝-->
          </button>
        </form>
        <!--* 고객 기능 끝-->
        <!--* 장바구니 시작-->
        <form class = "d-flex">
          <button class = "btn btn-outline-dark "
                  type = "submit"
          >
            <i class = "bi-cart-fill me-1"></i>
            Cart
            <span class = "badge bg-dark text-white ms-1 rounded-pill">0</span>
          </button>
        </form>
        <!--* 장바구니 끝-->
      </div>
    </div>
  </nav>
</template>

<script>
export default {}
</script>

<style>
</style>