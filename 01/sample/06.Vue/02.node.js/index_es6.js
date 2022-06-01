import { odd, even } from "./var_es6.js";
import checkOddOrEven from "./func_es6.js"; //func의 checkOddOrEven() 함수를 다른 것으로 정의하지 않고 들여오는 것이기 때문에 이름이 같아야함

// 문자열 길이가 홀수인지 짝수인지 판단하는 함수
function checkStringOddOrEven(str) {
    if (str.length % 2 ==1) {
        return odd;
    }
    return even;
}

console.log(checkOddOrEven(10))
//문자열 길이가 짝수인지 홀수 인지 판별
console.log(checkStringOddOrEven("heool"))