<template>
  <div id="app">
    <!-- 넘길 data가 없으면 써도 되는 형식 -->
    <TravelList />
  </div>
</template>

<script>
import TravelList from "@/components/TravelList.vue";

export default {
  name: "App",
  components: {
    TravelList,
  },
};
</script>

<style>
</style>
