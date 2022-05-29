app.component("review-form", {
    template:
        /* html */
        `
        <form class="review-form" @submit.prevent="onSubmit">
            <h3>Leave a review</h3>
            <label for="name">Name: </label>
            <input id="name" v-model="name" />

            <label for="review">Review: </label>
            <input id="review" v-model="review" />

            <label for="rating">Rating: </label>
            <select id="rating" v-model="rating">
                <option>5</option>
                <option>4</option>
                <option>3</option>
                <option>2</option>
                <option>1</option>
            </select>

            <label for="recommend">이 상품을 추천하시겠습니까?</label>
            <select id="recommend" v-model="recommend">
                <option>Yes</option>
                <option>No</option>
            </select>
            <input type="submit" classe="button" value="Submit" />
        </form>
    `,
    data() {
        return {
            /* 변수 초기화 */
            name: "",
            review: "",
            rating: "",
            recommend: "",
        }
    },
    methods: {
        onSubmit() {
            /* 1. name or(||) review or rating이 비어 있으면 메시지창 출력 */
            if(this.name === "" || this. review === "" || this.rating === "" || this.recommend === "") {
                alert("양식을 작성해 주세요")
                return
            }
            /* 2. productReview라는 이름으로 객체 정의 */
            let productReview = {
                name: this.name,
                review: this.review,
                rating: this.rating,
                recommend: this.recommend
            }
            /* 3. 부모에게 객체 쏴줄 신호 이름과, 매게변수 productReview */
            this.$emit("review-submitted", productReview)

            /* 4. 부모에게 쏴준 다음 깨끗이 변수 청소 */
            this.name = "";
            this.review = "";
            this.rating = "";
            this.recommend = "";

        }
    },
})