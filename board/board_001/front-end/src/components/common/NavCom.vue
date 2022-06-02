<template>
  <!-- * bootstrap dropdown 적용 -->
  <nav class = "navbar navbar-expand-lg navbar-dark bg-dark">
    <router-link to = "/"
                 class = "navbar-brand"
    >Menu
    </router-link>
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
        <li class = "nav-item dropdown">
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
            <router-link to = "/register"
                         class = "dropdown-item"
            >
              Register
            </router-link>
          </div>
        </li>
        <!-- * dropdown #2 -->
        <li class = "nav-item dropdown">
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
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
}
</script>

<style>
</style>