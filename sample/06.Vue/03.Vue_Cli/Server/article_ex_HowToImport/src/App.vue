<template>
  <div id="app">
    아티클<comp-article></comp-article>
    차일드<child-component></child-component>
  </div>
</template>

<script>
import ChildComponent from "./components/ChildComponent.vue"
import CompArticle from "./components/CompArticle.vue"


export default {
  name: 'App',
  components: {
    "child-component":CompArticle,
    "comp-article":ChildComponent
  }
}
</script>

<style>
</style>
