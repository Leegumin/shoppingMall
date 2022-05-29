<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>제품코드</th>
          <th>제품명</th>
          <th>가격</th>
          <th>설명</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="product in products" :key="product.pcode" @click="sendCode(product.pcode)">
          <td>{{ product.pcode }}</td> 
          <td>{{ product.pname }}</td> 
          <td>{{ product.price }}</td> 
          <td>{{ product.description }}</td> 
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      products: [
        {
          pcode: "p01",
          pname: "LG gram 노트북",
          price: 1750000,
          description: "OS: Windows 10 Home, CPU: Intel Core i7",
        },
        {
          pcode: "p02",
          pname: "페레가모 선글라스",
          price: 139000,
          description: "병행 수입",
        },
        {
          pcode: "p03",
          pname: "단골언니 신발",
          price: 12000,
          description: "저렴한 가격의 신발",
        }
      ]
    };
  },
  methods: {
    sendCode(pcode){
      const id = pcode;
      // productedit라는 주소를 찾아서 id(pcode)를 넘기면서 데이터 들어감
      // get 방식
      // 방법-1
      this.$router.push({path: `edit/${id}`})
      // 방법-2
      // this.$router.push({name: "productedit", params: {id}})
    }
  },
};
</script>