// const product = "Socks"

const app = Vue.createApp({
    data() {
        return {
            cart: [],
            prem: true
        }
    },
    methods: {
        // product-display의 add-to-cart라는 펑션을
        // 부모에서 updateCart 라는 이름으로 받음
        updateCart(id) {
            this.cart.push  (id)
        },
        removeById(id) {
            /* (배열의 index 번호, 삭제할 개수) */
            /* this.cart.splice(index, 1) */
            const index = this.cart.indexOf(id);
            /* indexOf에서 (조건)에 해당하는 값을 찾지 못하면 */
            /* -1을 반환하는데 if(index > -1) -> 조건에 걸리는*/
            /* 인덱스 값이 있으면 기능을 실행, 아니면 실행 안해주면 */
            /* 조건에 부합하지 않는 인덱스(-1) 삭제하는 것을 방지할 수 있음 */
            if(index > -1){
                this.cart.splice(index, 1)
            }
            
        }
    },
})//.mount("#app") /* 바로 연결해줘도 됨(이럴 경우 굳이 const app로 정의해줄 필요는 없어보임) */

/* html에서 호출 안하고 js에서 바로 붙여넣기 해줘도 됨 */
// app.mount("#app")
