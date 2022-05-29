<template>
  <div id="app">
    <our-header></our-header>
    <our-body></our-body>
    <our-footer></our-footer>
  </div>
</template>

<script>
import OurHeader from "./components/OurHeader.vue"
import OurBody from "./components/OurBody.vue"
import OurFooter from "./components/OurFooter.vue"

export default {
  name: "App",
  components: {
    OurHeader,
    OurBody,
    OurFooter
  }
}
</script>

<style>
/* #app {         
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
</style>
