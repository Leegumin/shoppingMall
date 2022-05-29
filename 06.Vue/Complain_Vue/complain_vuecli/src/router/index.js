import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/views/HomeView.vue')
  },
  {
    path: '/infoCup',
    name: 'infoCup',
    component: () => import('@/views/InfoCupView.vue')
  },
  {
    path: '/registerMember',
    name: 'registerMember',
    component: () => import('@/views/RegisterView.vue')
  },
  {
    path: '/complain',
    name: 'complain',
    component: () => import('@/views/ComplainView.vue')
  },
  {
    path: '*',
    name: 'notfound',
    component: () => import('@/views/NotFound.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
