const fs = require("fs")

fs.readFile("./readme.txt", (err, data) => {
    if(err) {
        /* 에러를 리턴하고 바로 작동중지 */
        throw err;
    }
    console.log(data)
    console.log(data.toString());
})