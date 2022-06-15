<template>
  <div id = "page-top">
    <!--Navbar-->
    <nav class = "navbar navbar-expand-lg navbar-dark bg-dark small sticky-top">
      <a class = "navbar-brand"
         href = "#"
      >
        <img src = "@/assets/img/heart.png"
             width = "30"
             height = "30"
             alt = ""
        >
      </a>
      <a class = "menu-toggle rounded mt-5"
         href = "#"
      >
        <button class = "btn btn-primary"
                id = "sidebarToggle"
        >Toggle Menu
        </button>
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
      <!--!------------------------------------------------>
      <div class = "d-flex"
           id = "wrapper"
      >
        <!-- Sidebar-->
        <div class = "border-end bg-white sidebar-nav mt-6"
             id = "sidebar-wrapper"
        >
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
      </div>
      <!--!------------------------------------------------>

    </nav>
    <!--Header-->
    <HeaderCom></HeaderCom>
    <!--Section-->
    <SectionCom></SectionCom>
    <!-- Map-->
    <div class = "map"
         id = "contact"
    >
      <iframe src = "https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A&amp;output=embed"></iframe>
      <br/>
      <small><a href = "https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A"></a></small>
    </div>
    <!--Footer-->
    <FooterCom></FooterCom>
  </div>
</template>

<script>
// Todo : bootstrap 테마 js 적용
// import loadWin from '@/assets/js/scripts'
import HeaderCom from '@/components/home/HeaderCom'
import FooterCom from '@/components/home/FooterCom'
import SectionCom from '@/components/home/SectionCom'
import loadWin from '@/assets/js/scripts'

export default {
  name      : 'HomeView',
  components: {
    HeaderCom,
    FooterCom,
    SectionCom,
  },
  mounted () {
    loadWin()
  },
}
</script>

<style>
</style>