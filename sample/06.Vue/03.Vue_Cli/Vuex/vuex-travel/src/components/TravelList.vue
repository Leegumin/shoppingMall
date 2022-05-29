<template>
  <div id="travel-list">
    <p>유럽여행</p>
    <ul>
      <li
        v-for="item in items"
        :key="item.attraction"
        @click="goCountry(item.country)"
      >
        <span>국가 : {{ item.country }}</span>
        <span>도시 : {{ item.city }}</span>
        <span>명소 : {{ item.attraction }}</span>
        <span>요금 : {{ item.entrance_fee | currency }}</span>
      </li>
    </ul>
    <!-- mutations 속성에 등록된 함수 호출 -->
    <button @click="reducePrice">특별 입장료 할인</button>
    <!-- 자식 컴퍼넌트 -->
    <TravellistDetails></TravellistDetails>
  </div>
</template>

<script>
import TravellistDetails from "./TravellistDetails.vue";

export default {
  components: {
    TravellistDetails,
  },
  methods: {
    /* vuex 저장소 데이터 호출 */
    goCountry(inValue) {
      /* 3. actions */
      this.$store.dispatch("goCountry", inValue);

      /* 2. mutations - store index.js의 mutations 속성에 등록된 goCountry 함수에 inValue 값이 inCountry 값으로 들어가면서 함수가 작동됨 */
      // this.$store.commit("goCountry", inValue);

      /* 1. getters - index에 goCountry 함수가 들어가서 막아둠 */
      // this.$store.state.selectedCountry = inValue;
    },
    reducePrice() {
      /* 3. actions */
      this.$store.dispatch("reducePrice");

      /* 2. mutations */
      // this.$store.commit("reducePrice");
    },
  },
  filters: {
    /* NumberFormat -> 함수명
    ("de-DE", { -> 나라 이름, "de-DE"는 독일
    style: "currency", -> 스타일이 적용될 이름 currency
    currency: "EUR", -> currency에 적용될 스타일은 "EUR"
    }).format(value); -> 포맷은 value에 들어오는 매개변수 */
    currency(value) {
      /* 나라의 통화 관련된걸 표시해주는 기능 */
      return new Intl.NumberFormat("de-DE", {
        style: "currency",
        currency: "EUR",
      }).format(value);
    },
  },
  computed: {
    items() {
      return this.$store.getters.items;
    },
  },
};
</script>

<style>
#travel-list {
  color: white;
  background: blue;
  padding: 10px 20px;
  text-align: center;
}
#travel-list ul {
  padding: 0;
  list-style-type: none;
}
#travel-list li {
  margin: 10px;
  padding: 20px;
  background: #1565c0;
}
</style>