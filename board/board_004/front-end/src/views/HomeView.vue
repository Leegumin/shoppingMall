<template>
  <div class="home">
    <!--네브바-->
    <NavCom></NavCom>
    <!--router-link 표시 위치 -->
    <router-view></router-view>
    <FooterCom></FooterCom>
  </div>
</template>

<script>
// @ is an alias to /src
import NavCom from '@/components/common/NavCom.vue'
import FooterCom from '@/components/common/FooterCom.vue'

export default {
  name: 'HomeView',
  components: {
    NavCom,
    FooterCom
  }
}
</script>

