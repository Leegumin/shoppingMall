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
    path     : '/tutorials',
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
  {
    path     : '/complains',
    name     : 'complain',
    component: () => import('@/components/complain/ComplainList'),
  },
  {
    path     : '/complains/add',
    alias    : '/add-complain',
    name     : 'add-complain',
    component: () => import('@/components/complain/AddComplain'),
  },
  {
    // /customers/:id, CustomerList에서 설정된 링크 "'/customers/' + customer.id" 형태에서 customer.id를 id(다른 이름도 가능함, ex - idx로 해도 작동하는거 확인됨)라는 이름의 매개변수로 사용하겠다.
    path     : '/complains/:id',
    alias    : '/edit-complain',
    name     : 'edit-complain',
    component: () => import('@/components/complain/EditComplain'),
  },
  {
    path     : '/free-boards',
    name     : 'free-boards',
    component: () => import('@/components/freeBoard/FreeBoardList'),
  },
  {
    path     : '/free-boards/add',
    alias    : '/add-boards',
    name     : 'add-boards',
    component: () => import('@/components/freeBoard/AddFreeBoard'),
  },
  {
    // /customers/:id, CustomerList에서 설정된 링크 "'/customers/' + customer.id" 형태에서 customer.id를 id(다른 이름도 가능함, ex - idx로 해도 작동하는거 확인됨)라는 이름의 매개변수로 사용하겠다.
    path     : '/free-boards/:id',
    alias    : '/edit-boards',
    name     : 'edit-boards',
    component: () => import('@/components/freeBoard/EditFreeBoard'),
  },
  {
    path     : '/faq-boards',
    name     : 'faq-boards',
    component: () => import('@/components/FAQBoard/FAQBoardList'),
  },
  {
    path     : '/faq-boards/add',
    alias    : '/add-faq-boards',
    name     : 'add-faq-boards',
    component: () => import('@/components/FAQBoard/AddFAQBoard'),
  },
  {
    // /customers/:id, CustomerList에서 설정된 링크 "'/customers/' + customer.id" 형태에서 customer.id를 id(다른 이름도 가능함, ex - idx로 해도 작동하는거 확인됨)라는 이름의 매개변수로 사용하겠다.
    path     : '/faq-boards/:id',
    alias    : '/edit-faq-boards',
    name     : 'edit-faq-boards',
    component: () => import('@/components/FAQBoard/EditFAQBoard'),
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
