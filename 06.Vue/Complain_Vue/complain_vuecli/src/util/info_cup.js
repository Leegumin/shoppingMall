function initPic() {
    let smallPics = document.querySelectorAll(".small");
      
    for(let i = 0; i < smallPics.length; i++) {
      smallPics[i].onclick = changePic;
    }
    /* is assigned a value but never used오류가 뜰때 eslint-disable-line no-unused-vars를 오류가 뜨는 부분에 주석으로 달면 사라짐 */
    /* 일단 쓸모없는 부분임 이 부분 */
    // let detailHref = document.getElementById('view');
    // detailHref.onclick = showDetail;
}


function changePic() {
    let cup = document.querySelector("#cup");
    // .small의 src
    let newPic = this.src;
    // cup의 src를 .small의 src로 세팅
    cup.src = newPic;
}

function showDetail() {
    document.querySelector('#detail').style.display = "block";
}

function hideDetail() {
    document.querySelector('#detail').style.display = "none";
}

/* 펑션 내보내기 */
export {initPic, changePic, showDetail, hideDetail}