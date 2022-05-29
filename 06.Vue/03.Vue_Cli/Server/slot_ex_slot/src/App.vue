<template>
  <div id="app">
    <!-- #1 예제 -->
    <!-- 부모컴포넌트(App.vue)에서 자식의 slot로  button을 보내줌 -->
    <!-- <ChildComponent>
      <button>버튼</button>
    </ChildComponent> -->

    <!-- #2 예제 -->
    <!-- <ChildComponent>
      <button slot="left">왼쪽버튼</button>
      <button slot="right">오른쪽버튼</button>
    </ChildComponent> -->

    <!-- #3 예제 -->
    <ChildComponent>
      <template v-slot:child="slotProps">
        <button @click="slotProps.close()">닫기</button>
        {{ slotProps.childData }}
      </template>
      
      <template v-slot:body>
         <p>바디입니다.</p> 
      </template>
    </ChildComponent>
  </div>
</template>

<script>
import ChildComponent from './components/ChildComponent.vue'

export default {
  name: 'App',
  components: {
    ChildComponent
  }
}
</script>

<style>
</style>
