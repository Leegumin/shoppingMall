<template>
  <div>
    <h3>Login 페이지</h3>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  // 라우터를 들어갈 때
  // to: 이동할 페이지 주소
  // from: 이동하기 전 페이지
  // next: 실질적으로 다음 페이지 이동이 일어나게 함(꼭 호출 필요)
  //즉 beforeRouteEnter의 역할은 일시정지.
  // beforeRouteEnter (to, from, next) {
  //   // ...
  // }
  beforeRouteEnter(to, from, next) {
    console.log(`beforeRouteEnter: `, to, `from:`, from);
    next();
  },

  // 라우터를 나갈 때
  beforeRouteLeave(to, from, next) {
    console.log(`beforeRouteLeave: `, to, `from:`, from);
    next();
  },
};
</script>
