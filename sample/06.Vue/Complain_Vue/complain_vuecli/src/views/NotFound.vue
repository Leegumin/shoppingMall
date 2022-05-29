<template>
  <div id="content">
    <h1>{{ title }}</h1>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "잘못된 접근입니다. Not Found"
    }
  },
}
</script>

<style scoped>
#content {
  margin-top: 200px;
  text-align: center;
}
</style>
