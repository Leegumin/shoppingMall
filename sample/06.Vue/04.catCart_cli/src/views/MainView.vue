<template>
  <div>
    <!-- 머리말 -->
    <my-header :cartItemCount="cartItemCount"></my-header>

    <!-- 본문 -->
    <main>
      <!-- showproducts start -->
      <!-- products 물품 반복문 추가 -->
      <!-- 반복문을 위한 div 추가 -->
      <div v-for="(product, index) in products" :key="index">
        <!-- row 태그 추가 -->
        <div class="row">
          <!-- 이미지 배치를 위한 원본 수정 -->
          <div class="col-md-5 col-md-offset-0">
            <!-- 원본 -->
            <!-- <div class="col-md-2 col-md-offset-1"> -->
            <figure>
              <!-- 3. 객체의 이미지 주소를 바인딩해서 넣어주세요 -->
              <!-- 이미지 배치를 위한 원본 수정 class는 v-for의 product와 동일해야 하는 것으로 추정됨-->
              <img class="product" :src="require(`@/${product.image}`)" alt="그림이 엄씀니다" />
              <!-- 원본 -->
              <!-- <img :src="product.image" alt="그림이 엄씀니다"> -->
            </figure>
          </div>
          <!-- 이미지 배치를 위한 원본 수정 -->
          <div class="col-md-6 col-md-offset-0 description">
            <!-- 원본 -->
            <!-- <div class="col-md-6 col-md-offset-2 description"> -->
            <!-- 4. v-text : products의 속성인 title 연결 -->
            <h1 v-text="product.title"></h1>
            <!-- 5. v-text : products의 속성인 description 연결 -->
            <p v-html="product.description"></p>
            <!-- 6. v-text : products의 속성인 price 연결($ + products.price 형태로 출력) -->
            <!-- 6. price가 세 자리 수마다 "," -->
            <!-- <p class="price"> {{ formatPrice }}</p> -->
            <!-- (1) 3자리를 구분하는 방법(옛날버전) 출력 위치 -->
            <p class="price">{{ product.price | formatPrice }}</p>

            <!-- 7.클릭시 addToCart 내에서 cart 배열에 products.id 추가 -->
            <!-- 8. 재고 수량 변수 크기만큼 장바구니에 담기면 아래 버튼을 안보이게 만드세요 -->
            <button
              v-if="canAddToCart(product)"
              class="btn btn-primary btn-lg"
              @click="addToCart(product)"
            >
              장바구니 담기
            </button>
            <!-- v-if가 사라지면 비활성화를 먹인 v-else 버튼이 나타남 -->
            <button v-else class="btn btn-primary btn-lg" disabled>
              장바구니 담기
            </button>

            <button
              class="btn btn-primary btn-lg"
              @click="removeToCart(product)"
            >
              장바구니 빼기
            </button>
            <!-- 재고수량 - 장바구니 수량 -> 품절 -->
            <!-- 재고수량 - 장바구니 수량 < 5 -> 남았습니다. -->
            <!-- 위의 조건이 다 아니면 -> 지금 구매하세요. -->
            <p class="inventory-message" v-if="soldOut(product)">품절</p>
            <!-- 2. 재고수량 - 장바구니 수량 < 5 {{ 재고수량 }} 남았습니다. -->
            <p class="inventory-message" v-else-if="remaining(product)">
              {{ remain(product) }} 남았습니다.
            </p>
            <!-- 3. 위의 조건이 다 해당 않되면 "지금 구매하세요" -->
            <p class="inventory-message" v-else>지금 구매하세요!!</p>
            <div class="rating">
              <!-- 아래 별을 반복문으로 5번 출력해주세요 -->
              <!-- v-for = " 저장될변수 이름 아무거나 in 반복할 숫자 -> 반복할 숫자만큼 태그의 시작부터 종료까지 반복함" -->
              <span v-for="rating in product.rating" :key="rating">☆</span>
            </div>
          </div>
        </div>
        <!--  row 태그 추가 end -->
        <hr />
        <!-- 수평선 추가 -->
      </div>
      <!-- showproducts end -->
    </main>
  </div>
</template>

<script>
// @ is an alias to /src
import MyHeader from "@/components/HeaderCom.vue";
import axios from 'axios'

export default {
  name: "MainView",
  data() {
    return {
      products: [],
      cart: [],
    };
  },
  components: { MyHeader },

  filters: {
    formatPrice(price) {
      return "$" + price.toLocaleString();
    },
  },
  computed: {
    //배열의 크기를 표시: 장바구니 담은 개수
    cartItemCount() {
      return this.cart.length;
    },
  },
  methods: {
    // 물품 추가
    addToCart(aProduct) {
      this.cart.push(aProduct.id);
    },
    // 물품 삭제
    removeToCart(aProduct) {
      this.cart.pop(aProduct.id);
    },
    // 각 물품별 카운트
    cartCount(id) {
      let count = 0;
      for (let i = 0; i < this.cart.length; i++) {
        if (this.cart[i] === id) {
          count++;
        }
      }
      return count;
    },
    // methods에 들어올 시에는 호출 값을 함수로 불러와줘야함
    canAddToCart(aProduct) {
      if (this.cartCount(aProduct.id) < aProduct.availableInventory) {
        return true;
      } else {
        return false;
      }
    },
    // 상품의 남은 수량
    remain(aProduct) {
      return aProduct.availableInventory - this.cartCount(aProduct.id);
    },
    //상품이 0 < 재고 < 5 일때
    remaining(aProduct) {
      return 0 < this.remain(aProduct) && this.remain(aProduct) < 5
        ? true
        : false;
    },
    //상품이 없을 때
    soldOut(aProduct) {
      return this.remain(aProduct) == 0 ? true : false;
    },

    

    submitForm() {
      alert("제출완료");
    },
  },
  created() {
    // if (APP_LOG_LIFE_CYCLE_EVENT == true) {
    //     console.log("created")
    // } //뷰가 생성 돼었을 때

    axios
      .get("./products.json")
      .then(
        function (response) {
          console.log(this);
          this.products = response.data.products;
          console.log(this.products);
        }.bind(this)
      )
      .catch(function (error) {
        console.log(error);
      });
  },
};
</script>