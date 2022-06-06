<template>
  <!-- * bootstrap dropdown 적용 -->
  <div>
    <nav class = "navbar navbar-expand-lg navbar-dark bg-dark">
      <router-link to = "/home"
                   class = "navbar-brand"
      >
        NOSINSA
      </router-link>
      <button class = "navbar-toggler"
              type = "button"
              data-toggle = "collapse"
              data-target = "#navbarSupportedContent"
              aria-controls = "navbarSupportedContent"
              aria-expanded = "false"
              aria-label = "Toggle navigation"
      >
        <span class = "navbar-toggler-icon"></span>
      </button>

      <div class = "collapse navbar-collapse"
           id = "navbarSupportedContent"
      >
        <ul class = "navbar-nav mr-auto">
          <!-- * dropdown #1 시작-->
          <li class = "nav-item dropdown active">
            <a class = "nav-link dropdown-toggle"
               href = "#"
               id = "navbarDropdown"
               role = "button"
               data-toggle = "dropdown"
               aria-haspopup = "true"
               aria-expanded = "false"
            >
              About
            </a>
            <div class = "dropdown-menu"
                 aria-labelledby = "navbarDropdown"
            >
              <router-link to = "#"
                           class = "dropdown-item"
              >
                #
              </router-link>
              <!--              <div class = "dropdown-divider"></div>
                            <a class = "dropdown-item"
                               href = "#"
                            >Something else here</a>-->
            </div>
          </li>
          <!-- * dropdown #1 끝-->
          <!-- * dropdown #2 시작-->
          <li class = "nav-item dropdown active">
            <a class = "nav-link dropdown-toggle"
               href = "#"
               id = "navbarDropdown"
               role = "button"
               data-toggle = "dropdown"
               aria-haspopup = "true"
               aria-expanded = "false"
            >
              Tutorial Menu
            </a>
            <div class = "dropdown-menu"
                 aria-labelledby = "navbarDropdown"
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
              <!--              <div class = "dropdown-divider"></div>
                            <a class = "dropdown-item"
                               href = "#"
                            >Something else here</a>-->
            </div>
          </li>
          <!-- * dropdown #2 끝-->
          <!-- * 회원가입 시작-->
          <li class = "nav-item active">
            <router-link to = "/register"
                         class = "nav-link"
            >
              회원가입 <span class = "sr-only">(current)</span>
            </router-link>
          </li>
          <!-- * 회원가입 끝-->
        </ul>
        <!--* 검색창 시작-->
        <form class = "form-inline my-2 my-lg-0">
          <input class = "form-control mr-sm-2"
                 type = "search"
                 placeholder = "Search"
                 aria-label = "Search"
          >
          <button class = "btn btn-outline-info my-2 my-sm-0"
                  type = "submit"
          ><i class = "fa fa-search"
              aria-hidden = "true"
          ></i>
          </button>
        </form>
        <!--* 검색창 끝-->
      </div>
    </nav>
  </div>
</template>

<script>
export default {}
</script>

<style>
.bd-navbar {
  position: sticky;
  top: 0;
  z-index: 1071;
  min-height: 4rem;
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, .05), inset 0 -1px 0 rgba(0, 0, 0, .1);
}
</style>