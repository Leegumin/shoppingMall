import Vue from 'vue'
import VueRouter from 'vue-router'

// *router : 메뉴달기 비교) springboot의 controller와 유사
Vue.use(VueRouter)

const routes = [
  {
    path     : '/',
    name     : '',
    component: () => import('@/views/HomeView'),
    children : [
      {
        path     : '/',
        alias    : '/home', //alias 값으로도 페이지 인식함
        name     : 'home',
        component: () => import('@/components/home/HomeCom'),
      },
    ],
  },
  {
    path     : '/',
    name     : '',
    component: () => import('@/views/NoneNavFooterView'),
    children : [
      {
        path     : '/login',
        name     : 'login',
        component: () => import('@/components/user/Login'),
      },
      {
        path     : '*',
        name     : 'notfound',
        component: () => import('@/views/NotFound'),
      },
    ],
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
