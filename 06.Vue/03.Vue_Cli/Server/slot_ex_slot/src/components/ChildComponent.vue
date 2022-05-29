<template>
  <div>
    <!-- #1 예제 -->
    <!-- 부모컴포넌트(App.vue)의 button을 받아옴 -->
    <!-- <slot></slot> -->

    <!-- #2 예제 -->
    <!-- 왼쪽 버튼 -->
    <!-- <slot name="left"></slot> -->
    <!-- 오른쪽 버튼 -->
    <!-- <slot name="right"></slot> -->
    
    <!-- #3 예제 -->
    <header>
      <slot name="child" :childData="childData" :close="close"></slot>
    </header>
    <div>
      <slot name="body">
      </slot>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      childData: "child",
      active: false
    }
  },
  methods: {
    close() {
      this.active = false;
      alert(this.active);
    }
  },
}
</script>

<style>

</style>