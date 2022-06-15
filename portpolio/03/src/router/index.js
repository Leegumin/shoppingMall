import Vue from 'vue'
import VueRouter from 'vue-router'

// *router : 메뉴달기 비교) springboot의 controller와 유사
Vue.use(VueRouter)

const routes = [
  // * /, /tutorials 메뉴를 클릭하면 TutorialsList.vue 로딩
  // TutorialsList.vue : Tutorial 목록 화면
  {
    path     : '/',
    alias    : '/home', //alias 값으로도 페이지 인식함
    name     : 'home',
    component: () => import('@/views/HomeView'),
  },
  {
    path     : '/complain',
    name     : 'complain',
    component: () => import('@/views/ComplainView'),
  },
  {
    path     : '/tutorials',
    alias    : '/tutorials',
    name     : 'tutorials',
    component: () => import('@/components/tutorials/TutorialsList'),
  },
  // Tutorial : Tutorial 화면 상세
  {
    path     : '/tutorials/:id',
    name     : 'tutorial-details',
    component: () => import('@/components/tutorials/Tutorial'),
  },
  // AddTutorial : Tutorial 목록 추가 화면
  {
    path     : '/add',
    name     : 'add',
    component: () => import('@/components/tutorials/AddTutorial'),
  },
  // UploadImage 목록 추가 화면
  {
    path     : '/upload',
    name     : 'upload',
    component: () => import('@/components/tutorials/UploadImage'),
  },
  {
    path     : '/customers',
    alias    : '/customers',
    name     : 'customers',
    component: () => import('@/components/customer/CustomerList'),
  },
  {
    path     : '/customers/add',
    alias    : '/add-customers',
    name     : 'add-customers',
    component: () => import('@/components/customer/AddCustomer'),
  },
  {
    // /customers/:id, CustomerList에서 설정된 링크 "'/customers/' + customer.id" 형태에서 customer.id를 id(다른 이름도 가능함, ex - idx로 해도 작동하는거 확인됨)라는 이름의 매개변수로 사용하겠다.
    path     : '/customers/:id',
    alias    : '/edit-customers',
    name     : 'edit-customers',
    component: () => import('@/components/customer/EditCustomer'),
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
