<template>
  <div class="home">
    <HomeCome />
  </div>
</template>

<script>
// @ is an alias to /src
import HomeCome from '@/components/HomeCom.vue'

export default {
  name: "HomeView",
  components: {
    HomeCome
  },
};
</script>
