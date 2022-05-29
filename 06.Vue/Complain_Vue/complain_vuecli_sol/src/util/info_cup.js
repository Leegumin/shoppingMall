function initPic() {
    let smallPics = document.querySelectorAll(".small");
      
    for(let i = 0; i < smallPics.length; i++) {
      smallPics[i].onclick = changePic;
    }

}


function changePic() {
    var cup = document.querySelector("#cup");
    // .small의 src
    var newPic = this.src;
    // cup의 src를 .small의 src로 세팅
    cup.src = newPic;
}

function showDetail() {
    document.querySelector('#detail').style.display = "block";
}

function hideDetail() {
    document.querySelector('#detail').style.display = "none";
}

// 평션 여러개 내보내기
export { initPic, changePic, showDetail, hideDetail }