import Vue from 'vue'
import VueRouter from 'vue-router'
// import HomeView from '../views/HomeView.vue'

// 자동으로 절대경로를 찾아주는 방법(VueCli에서 제공, src까지 경로를 다 붙여줌)
import HomeView from '@/views/HomeView.vue'
import LoginView from '@/views/LoginView.vue'
import NotFound from '@/views/NotFound.vue'

Vue.use(VueRouter)

const routes = [
  // 홈페이지
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  // 로그인페이지
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  // 에러페이지
  {
    path: '*',
    name: 'notfound',
    component: NotFound
  },
  // 중메뉴 홈페이지 컴포넌트에서 바로 받아옴
  // 어드민페이지
  {
    path: '/admin',
    name: 'admin',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '@/views/admin/AdminView.vue'),
    // 애드민의 자식 컴포넌트
    children : [
      {
        path: 'list',
        name: 'productlist',
        component: () => import('@/views/admin/ProductList.vue')
      },
      {
        path: 'edit/:id',
        name: 'productedit',
        component: () => import('@/views/admin/ProductEdit.vue')
      },
      {
        path: 'insert',
        name: 'productinsert',
        component: () => import('@/views/admin/ProductInsert.vue')
      }    
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
