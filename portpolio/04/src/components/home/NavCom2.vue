<template>
  <div id = "wrapper">
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
              <router-link to = "/complain"
                           class = "dropdown-item"
              >
                Complain
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
        </ul>
      </div>
    </nav>
    <a class = "menu-toggle rounded mt-5"
       href = "#"
    ><i class = "fas fa-bars"></i></a>
    <nav id = "sidebar-wrapper">
      <ul class = "sidebar-nav">
        <li class = "sidebar-brand"><a href = "#page-top">Start Bootstrap</a></li>
        <li class = "sidebar-nav-item"><a href = "#page-top">Home</a></li>
        <li class = "sidebar-nav-item"><a href = "#about">About</a></li>
        <li class = "sidebar-nav-item"><a href = "#services">Services</a></li>
        <li class = "sidebar-nav-item"><a href = "#portfolio">Portfolio</a></li>
        <li class = "sidebar-nav-item"><a href = "#contact">Contact</a></li>
      </ul>
    </nav>
    <!--!------------------------------------------------>
    <button class = "btn btn-primary"
            id = "sidebarToggle"
    >Toggle Menu
    </button>
    <div class = "d-flex"
         id = "wrapper"
    >
      <!-- Sidebar-->
      <div class = "border-end bg-white"
           id = "sidebar-wrapper"
      >
        <div class = "sidebar-heading border-bottom bg-light">Start Bootstrap</div>
        <div class = "list-group list-group-flush">
          <a class = "list-group-item list-group-item-action list-group-item-light p-3"
             href = "#!"
          >Dashboard</a>
          <a class = "list-group-item list-group-item-action list-group-item-light p-3"
             href = "#!"
          >Shortcuts</a>
          <a class = "list-group-item list-group-item-action list-group-item-light p-3"
             href = "#!"
          >Overview</a>
          <a class = "list-group-item list-group-item-action list-group-item-light p-3"
             href = "#!"
          >Events</a>
          <a class = "list-group-item list-group-item-action list-group-item-light p-3"
             href = "#!"
          >Profile</a>
          <a class = "list-group-item list-group-item-action list-group-item-light p-3"
             href = "#!"
          >Status</a>
        </div>
      </div>
      <!--!------------------------------------------------>
    </div>
  </div>
</template>

<script>
import loadWin from '@/assets/js/scripts'

export default {
  name: 'NavCom',
  mounted () {
    loadWin()
  },
}
</script>

<style scoped>
</style>