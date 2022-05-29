import Vue from 'vue'
import VueRouter from 'vue-router'

// *router : 메뉴달기 비교) springboot의 controller와 유사
Vue.use(VueRouter)

const routes = [
  // * /, /tutorials 메뉴를 클릭하면 TutorialsList.vue 로딩
  // TutorialsList.vue : Tutorial 목록 화면
  // {
  //   path     : '/',
  //   alias    : '/tutorials',
  //   name     : 'tutorials',
  //   component: () => import('@/components/TutorialsList'),
  // },
  // // Tutorial : Tutorial 화면 상세
  // {
  //   path: '/tutorials/:id',
  //   name: 'tutorial-details',
  //   component: () => import('@/components/Tutorial'),
  // },
  // // AddTutorial : Tutorial 목록 추가 화면
  {
    path: '/add',
    name: 'add',
    component: () => import('@/components/AddTutorial'),
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
