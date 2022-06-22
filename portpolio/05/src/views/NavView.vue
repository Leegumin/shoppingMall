<template>
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
        <li class = "nav-item mx-4 active">
          <a href = "#Hello"
             class = "nav-link active h4"
             aria-current = "page"
          >
            Hello
          </a>
        </li>
        <li class = "nav-item mx-4 active">
          <a href = "#AboutMe"
             class = "nav-link active h4"
             aria-current = "page"
          >
            About Me
          </a>
        </li>
        <li class = "nav-item mx-4 active">
          <a href = "#Skills"
             class = "nav-link active h4"
             aria-current = "page"
          >
            Skills
          </a>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'NavView',
}
</script>

<style scoped>

</style>