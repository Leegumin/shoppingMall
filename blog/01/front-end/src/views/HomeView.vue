<template>
  <div id = "page-top">
    <!-- Navigation-->
    <!--p(padding), m(margin)/l(left), r(right), t(top), b(bottom)-1~5-->
   <a class = "menu-toggle rounded mt-5"
       href = "#"
    ><i class = "fas fa-bars"></i></a>
    <nav id = "sidebar-wrapper">
      <ul class = "sidebar-nav">
        <li class = "sidebar-brand"><a href = "#page-top">Start Bootstrap</a></li>
        <li class = "sidebar-nav-item"><a href = "#Hello">Top</a></li>
        <li class = "sidebar-nav-item"><a href = "#AboutMe">About Me</a></li>
        <li class = "sidebar-nav-item"><a href = "#Skills">Skills</a></li>
        <li class = "sidebar-nav-item"><a href = "#Project">Project</a></li>
      </ul>
    </nav>
    <!--Header-->
    <HeaderCom></HeaderCom>
    <!--Section-->
    <SectionCom></SectionCom>
    <!--Footer-->
    <FooterCom></FooterCom>
  </div>
</template>

<script>
// Todo : bootstrap 테마 js 적용
import loadWin from '@/assets/js/scripts'
import HeaderCom from '@/components/home/HeaderCom'
import FooterCom from '@/components/home/FooterCom'
import SectionCom from '@/components/home/SectionCom'

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
/*Todo : bootstrap 테마 사용자 css import*/
@import '@/assets/css/styles.css';
</style>