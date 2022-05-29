import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  /* 공유 data를 등록하는 자리 */
  state: {
    items: [
      {
        country: "France",
        city: "Paris",
        attraction: "에펠탑",
        entrance_fee: 10
      },
      {
        country: "Italy",
        city: "Venezia",
        attraction: "산마르코 대성당",
        entrance_fee: 0
      },
      {
        country: "Austria",
        city: "Salzburg",
        attraction: "호엔잘쯔부르크성",
        entrance_fee: 15.20
      },
      {
        country: "Germany",
        city: "Frankfurt",
        attraction: "뢰머광장",
        entrance_fee: 0
      },
      {
        country: "Nederland",
        city: "Amsterdam",
        attraction: "국립미술관",
        entrance_fee: 17.50
      }
    ],
    selectedCountry: ""
  },
  /* 가져올 함수 state는 함수의 매개변수 */
  /* 조건이 참이면 값을 가져옴 */
  /* 원본데이터를 검색하는 목적 */
  getters: {
    items: state => {
      return state.items
    },
    /* 관광지 객체 배열에서 선택된 나라 값과 동일한 것만 가져옴 */
    filteredItems: state => {
      /* filter(함수) -> 매개변수 값이 참인것만 가져옴 */
      return state.items.filter(item => {
        return item.country == state.selectedCountry
      })
    }
  },
  /* setter와 같은 역할, 데이터를 가져와서 변경해서 저장함 */
  /* 원본 데이터를 변형, 가공하는 목적 */
  mutations: {
    reducePrice: state => {
      state.items.forEach(item => {
        item.entrance_fee = (item.entrance_fee - (item.entrance_fee * 0.2))
      })
    },
    goCountry: (state, inCountry) => {
      state.selectedCountry = inCountry;
    }
  },
  /* 지정된 함수를 지연시키는 용도로 사용 */
  actions: {
    /* 비동기함수 호출 */
    reducePrice: context => {
      setTimeout(function () {
        context.commit("reducePrice");
      }, 4000)
    },
    /* 그냥 함수 호출 */
    goCountry: (context, inCountry) => {
      context.commit("goCountry", inCountry)
    }
  },
  // 
  modules: {

  }
})
