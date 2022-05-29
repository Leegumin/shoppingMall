/* app.component 의 app은 index가 아니라 main.js에서 정의된 app을 말하는거임 */
app.component("product-display", {
    props: {
        /* 자식에서는 premium이라는 이름으로 부모의 prem 값을 받아옴 */
        premium: {
            /* 프리미엄 데이터에 대한 성격(혹은 속성). 실제 premium의 값은 부모에서 받아오기 때문에 부모에 있음 */
            type: Boolean,
            required: true
        }
    },
    template:
        /* html */
        `
    <div class="product-display">
        <div class="product-container">
            <div class="product-image">
                <img :class="{ 'out-of-stock-img': !InStock }" :src="image" alt="그림이 없습니다.">
            </div>

            <div class="product-info">
                <h1>{{ title }}</h1>
                <h1 v-if="onSale"> {{ saleMessage }}</h1>
                <p v-if="InStock">InStock</p>
                <p v-else>Out of Stock</p>
                <p>Shipping : {{ shipping }}</p>
                <product-details :childDetails="details" />
                
                <div v-for="(item, index) in variants" :key="index" @mouseover="updateImage(index)"
                    class="color-circle" :style="{backgroundColor: item.color}">
                </div>
                <button class="button" @click="addToCart" :class="{ disabledButton: !InStock }"
                    :disabled="!InStock">Add To Cart</button>
                <button class="button" @click="DeleteToCart">Delete To Cart</button>
            </div>
        </div>
        <!-- 양식 내용 보여주기 -->
        <review-list v-if="reviews.length" :reviews="reviews" />
        <!-- 양식 작성 입력란 -->
        <review-form @review-submitted="addReview" />
    </div>
    `,
    data() {
        return {
            product: "Socks",
            brand: "Vue Mastery",
            selectedVariant: 0,
            reviews: [],
            /* computed image()로 대체 */
            // image: "./assets/images/socks_01.jpg",
            /* computed image()로 대체 */
            // InStock: false,
            details: ["50% cooton", "30% wool", "20% polyester"],
            variants: [
                {
                    id: 2234,
                    color: "green",
                    image: "./assets/images/socks_01.jpg",
                    quantity: 50
                },
                {
                    id: 2235,
                    color: "blue",
                    image: "./assets/images/socks_02.jpg",
                    quantity: 20
                }
            ],
        }
    },
    methods: {
        addToCart() {
            // 컴포넌트화 되어서 부모쪽으로 클릭 이벤트 신호를 보냄
            // add-to-cart라는 이름으로 variants라는 이름의 배열의 selectedVariant라는 인덱스 넘버의 id를 매개변수로 넘겨줌
            this.$emit("add-to-cart", this.variants[this.selectedVariant].id)
        },
        DeleteToCart() {
            this.$emit("remove-from-cart", this.variants[this.selectedVariant].id)
        },
        updateImage(index) {
            this.selectedVariant = index
        },
        addReview(review) {
            this.reviews.push(review)
        }
    },
    /* computed: 양방향 바인딩(binding) 기술 */
    /* 데이터를 감시하다가 변경되면 자동 화면 갱신을 시켜줌 */
    /* 데이터가 변경 안되도 화면에 보여줌 -> 성능 개선의 효과(미리 결과 데이터를 임시 저장공간(캐시)에 저장해 두기 때문) */
    /* 때문에 methods에는 주로 이벤트(click, mouseoverm, omuseleave 등) */
    /* 때문에 computed에는 매개변수가 없거나, 데이터가 실시간으로 변화는 계산식 */
    computed: {
        title() {
            return `${this.brand} ${this.product}`
        },
        saleMessage() {
            return `${this.brand} ${this.product} is on sale!!`
        },
        image() {
            return this.variants[this.selectedVariant].image
        },
        onSale() {
            return false
        },
        InStock() {
            // return this.variants[this.selectedVariant].quantity > 0 ? 1:0
            /* 혹은 어차피 1 이상은 true, 0은 false 값을 가지기 때문에 삼항 빼도 됨 */
            return this.variants[this.selectedVariant].quantity
        },
        shipping() {
            return this.premium ? "Free" : "$" + 2.99
        }
    }
})


