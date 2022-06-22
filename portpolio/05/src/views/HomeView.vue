<template>
  <div id = "page-top">
    <!-- Navigation-->
    <!--p(padding), m(margin)/l(left), r(right), t(top), b(bottom)-1~5-->
<!--    <a class = "menu-toggle rounded mt-5"
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
    </nav>-->
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