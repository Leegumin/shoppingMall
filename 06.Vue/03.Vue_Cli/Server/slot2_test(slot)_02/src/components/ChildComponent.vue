<template>
  <div>
    <!-- 예시 1) -->
    <!-- cities를 부모에서 넘겨주지 않으면 출력할 자료가 없어서 -->
    <!-- name, text는 출력이 안됨 -->
    <!-- 허나 cities가 넘어오면 모든 자료가 넘어와서 v-for -->
    <!-- 반복문에 의해 출력이 되기 때문에 결국 밑의 name와 text는 의미가 없음 -->
    <!-- <slot name="cities"></slot> -->
    <!-- <slot name="name"></slot>
    <slot name="text"></slot> -->

    <!-- 예시 2) -->
    <slot></slot>
  </div>
</template>