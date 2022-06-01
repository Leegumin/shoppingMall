<template>
  <div id="travelist-details">
    <p>{{ this.$store.state.selectedCountry }}</p>
    <ul>
      <li v-for="item in filterdItems" :key="item.attraction">
        <span>도시 : {{ item.city }}</span>
        <span>명소 : {{ item.attraction }}</span>
        <span>요금 : {{ item.entrance_fee | currency }}</span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
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
    filterdItems() {
      return this.$store.getters.items.filter((item) => {
        return item.country == this.$store.state.selectedCountry;
      });
    },
  },
};
</script>

<style>

#travelist-details {
  color: white;
  background: teal;
  padding: 10px 20px;
}
#travelist-details ul {
  padding: 0;
  list-style-type: none;
}
#travelist-details ul li {
  margin: 10px;
  padding: 20px;
  background: #00695c;
}
</style>