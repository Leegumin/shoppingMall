/* app.component 의 app은 index가 아니라 main.js에서 정의된 app을 말하는거임 */
app.component("product-details", {
    props: {
        childDetails: {
            type: Array,
            required: true
        }
    },
    template:
    /* html */
    `
    <ul>
        <li v-for="(item, index) in childDetails" :key="index">{{ item }}</li>
    </ul>
    `,
})