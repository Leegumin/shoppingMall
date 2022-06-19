import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

// 스타일 전체 적용
// import "@/assets/css/styles.css"

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
