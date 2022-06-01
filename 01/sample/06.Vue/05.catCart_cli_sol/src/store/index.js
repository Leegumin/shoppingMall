import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
// 모듈 추가
// import products from './modules/products.js';

Vue.use(Vuex)

export default new Vuex.Store({
  // modules: {
  //   products
  // },

  state: {
    products: []
  },
  mutations: {
    'SET_STORE'(state, products) {
      state.products = products;
      console.log("SET_STORE: " + state.products)
    }
  },
  actions: {
    initStore: (context) => {
      axios.get("/static/products.json")
      .then((response) => {
        console.log("initSotre: " + response);
        context.commit('SET_STORE', response.data.products)
      })
      .catch((err) => {
        console.log(err)
      });
    }
  },
  getters: {
    products: state => state.products
  }
})