<template>
  <header>
    <!-- class -> 부트스트랩 적용됨 -->
    <div class="navbar navbar-default">
      <div class="navbar-header">
        <h1>{{ sitename }}></h1>
      </div>
      <!-- 장바구니 카운트 표시 -->
      <div class="nav navbar-nav navbar-right cart">
        <button
          type="button"
          class="btn btn-default btn-lg"
          @click="showCheckout"
        >
          <!-- 9.본문 열기닫기 생성 -->
          <div v-for="(product, index) in products" :key="index">
            <!-- 글자 왼쪽 정렬 -->
            <h5 class="text-left">
              {{ product.title }}:
              <span class="glyphicon glyphicon-shopping-cart">{{
                cartCount(product.id)
              }}</span>
            </h5>
          </div>
          <!-- 글자 왼쪽 정렬 -->
          <div class="text-left">
            <span class="glyphicon glyphicon-shopping-cart"
              >총합:{{ cartItemCount }}</span
            >
            <strong>(체크아웃)</strong>
          </div>
        </button>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "my-header",
  data() {
    return {
      sitename: "Vue.js 애완용품샵",
    };
  },
  props: ["cartItemCount"],
  methods: {
    showCheckout() {
      this.showproducts = this.showproducts == true ? false : true;

      // if (this.showproducts == true) {
      //     this.showproducts = false
      // }
      // else {
      //     this.showproducts = true
      // }
    },
  },
};
</script>

<style scoped>
a {
  text-decoration: none;
  color: black;
}
.router-link-exact-active {
  color: black;
}
</style>