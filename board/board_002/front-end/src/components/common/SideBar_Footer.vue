<template>
  <div>
    <!--사이드바-->
    <div class = "col-3 bd-sidebar">
      <br>
      <ul class = "nav">
        <!--대메뉴 #1-->
        <li><h6><strong>카테고리</strong></h6></li>
        <!-- 소메뉴 -->
        <li><a href = "#">데이터</a></li>
      </ul>
      <br>
      <ul class = "nav">
        <!--대메뉴 #2-->
        <li><h6><strong>최근 글</strong></h6></li>
        <!-- 소메뉴 -->
        <li><a href = "#">데이터</a></li>
      </ul>
      <br>
      <ul class = "nav">
        <!--대메뉴 #3-->
        <li><h6><strong>링크</strong></h6></li>
        <!-- 소메뉴 -->
        <li v-for = "(asideDomain, index) in asideDomains"
            :key = "index"
        >
          <a :href = "asideDomain.href"
             target = "_blank"
          >{{
              asideDomain.name
           }}</a></li>
      </ul>
      <br>
      <div class='bd-sidebar-footer'>
        <footer id = "main-footer">
          <a href = "#">Created By Mingu </a>
        </footer>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SideBar',
  data () {
    return {
      asideDomains: [
        {
          name: '구글',
          href: 'http://www.google.com',
        },
        {
          name: '네이버',
          href: 'http://www.naver.com',
        },
        {
          name: '다음',
          href: 'http://www.daum.net',
        },
      ],
    }
  },
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

.bd-sidebar-footer {
  padding: 0.5rem;
  background: #ddd;
}

a {
  color: black;
}
</style>