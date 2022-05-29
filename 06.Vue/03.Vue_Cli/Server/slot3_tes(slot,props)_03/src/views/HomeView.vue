<template>
  <div class="home">
    <!-- 랜덤하게 객체 하나를 자식컴포넌트에게 데이터 전달 -->
    <!-- 1. props 를 이용하여 데이터 전달 : ran_city ="randomCity" -->
    <child-comp :ran_city="randomCity">
      <!-- 2. slot의 name를 이용하여 데이터 전달 name: best -->
      <div slot="best">
        <figure>
          <img src="@/assets/img/vienna.jpg" alt="이미지가 없습니다." />
          <figcaption>비엔나(Vienna)</figcaption>
        </figure>
      </div>
      <!-- 3. slot의 name를 이용하여 데이터 전달 name: footer -->
      <div slot="footer">
        <footer>
          <p>&copy; All right reserved</p>
        </footer>
      </div>
    </child-comp>
  </div>
</template>

<script>
// @ is an alias to /src
import ChildComp from "@/components/ChildComp.vue";
// 자식컴포넌트 가져오기 ChildComp
export default {
  name: "HomeView",
  components: {
    "child-comp": ChildComp,
  },
  data() {
    return {
      cities: [
        {
          cityname: "paris",
          pic: require("@/assets/img/paris.jpg")
        },
        {
          cityname: "amsterdam",
          pic: require("@/assets/img/amsterdam.jpg")
        },
        {
          cityname: "dresden",
          pic: require("@/assets/img/dresden.jpg")
        },
      ],
    };
  },
  computed: {
    randomCity() {
      // 배열에서 랜덤하게 호출
      //[Math.floor(Math.random() * 랜덤을 적용시킬 배열의 길이)];
      return this.cities[Math.floor(Math.random() * this.cities.length)];
    },
  },
};
</script>
