import { odd, even } from "./var_es6.js";

function checkOddOrEven(num) {
    if (num % 2 == 1) {
        return odd;
    }
    return even;
}

export default checkOddOrEven //하나짜리는 default 넣어주면 됨