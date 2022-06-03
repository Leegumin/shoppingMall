<template>
  <div>
    <!--사이드바-->
    <div class="col-3 bd-sidebar">
      <ul class="nav">
        <li><a>Side 1</a></li>
        <li><a>Side 2</a></li>
        <li><a>Side 3</a></li>
        <li><a>Side 4</a></li>
        <li><a>Side 5</a></li>
        <li><a>Side 6</a></li>
        <li><a>Side 7</a></li>
        <li><a>Side 8</a></li>
      </ul>

      <!--대메뉴-->
      <h5>카테고리</h5>
      <!-- 소메뉴 -->
      <ul class="nav">
        <li><a href = "#">데이터</a></li>
      </ul>

    </div>
    <!-- 오른쪽 사이드 메뉴 -->
    <aside id = "main-aside">
      <!-- 첫 번째 대메뉴 -->
      <div class = "aside-list">
        <h3>카테고리</h3>
        <!-- 소메뉴 -->
        <ul>
          <li><a href = "#">데이터</a></li>
        </ul>
      </div>
      <!-- 두 번째 대메뉴 -->
      <div class = "aside-list">
        <h3>최근 글</h3>
        <!-- 소메뉴 -->
        <ul>
          <li><a href = "#">데이터</a></li>
        </ul>
      </div>
      <div class = "aside-list">
        <h3>링크</h3>
        <ul>
          <li v-for = "(asideDomain, index) in asideDomains"
              :key = "index"
          >
            <a :href = "asideDomain.href"
               target = "_blank"
            >{{
                asideDomain.name
             }}</a>
          </li>
        </ul>
      </div>
    </aside>
  </div>
</template>

<script>
export default {
  name: 'SideBar',
}
</script>

<style scoped>
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