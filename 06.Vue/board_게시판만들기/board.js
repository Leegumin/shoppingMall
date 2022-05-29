/* 자식 컴포넌트 객체 정의 */
/* 게시판 목록 보기 컴포넌트 */
let MyBoardList = {
    props: ["object"],
    template:
        /* html */
        `
                <div>
                    <table id="list">
                        <tr>
                            <th style="widht: 50px">글번호</th>
                            <th>글제목</th>
                            <th style="widht: 50px">조회수</th>
                            <th style="widht: 70px"></th>
                        </tr>
                        <tr v-for = "item in object" :key="item.no">
                            <td>{{ item.no }}</td>
                            <td @click="ChildBoardRead(item)">
                                {{ item.title }}
                            </td>
                            <td>{{ item.view }}</td>
                            <td>
                                <button @click="ChildBoardDelete(item.no)">
                                    삭제
                                </button>
                            </td>
                        </tr>
                    </table>
                    <button @click="ChildBoardWrite"
                            style="float:right;">
                            글쓰기
                    </button>
                </div>
            `,
    methods: {
        /* 부모 컴포넌트로 신호 전송 */
        ChildBoardRead: function (info) {
            this.$emit("board-read", info);
        },
        ChildBoardWrite: function (info) {
            this.$emit("board-write");
        },
        ChildBoardDelete: function (no) {
            this.$emit("board-delete", no);
        }
    },
}
/* 게시판 상세 목록 보기 컴포넌트 */
let MyBoardRead = {
    props: ["object"],
    template:
        /* html */
        `
                <div>
                    <table id="list">
                        <tr>
                            <td style="width:50px">글 제목</td>
                            <td>{{ object.title }}</td>
                        </tr>
                        <tr style="height:300px">
                            <td colspan="2">{{ object.content }}</td>
                        </tr>
                    </table>
                    /* 목록 화면으로 되돌아가기 버튼 */
                    <button
                        @click="ChildBoardList" 
                        style="float: right;">
                        목록
                    </button>
                </div>
            `,
    methods: {
        /* 부모 컴포넌트로 신호 전송 */
        /* template에서 button click에 발생되는 함수로 ChildBoardList를 지정 */
        /* 이 함수는 부모에게 "board-list"로 지정돼 있는 값을 실행시키라고 신호를 전송함 */
        ChildBoardList: function () {
            this.$emit("board-list")
        },

    },
}
/* 새글쓰기 컴포넌트 */
let MyBoardWrite = {
    template:
        /* html */
        `
                <div>
                    <table id="list">
                        <tr>
                            <td>글 제목</td>
                            <td>
                                <input type="text" v-model="title" style="width:90%">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea v-model="content" style="width:100%">
                                </textarea>
                            </td>
                        </tr>
                    </table>
                    // 목록으로 돌아가기 버튼
                    <button @click="ChildBoardList" style="float: right">목록</button>
                    // 저장하기 버튼
                    <button @click="ChilidBoardSave" style="float: right">저장</button>
                </div>
            `,
    methods: {
        ChildBoardList: function () {
            this.$emit("board-list");
        },
        ChilidBoardSave: function () {
            this.$emit("board-save", this.title, this.content);
        }
    },
    data: function () {
        return {
            title: "",
            content: ""
        }
    }
}
new Vue({
    el: "#app",
    data() {
        return {
            dataArray: [],
            listOk: false,
            readOk: false,
            writeOk: false,
            boardInfo: {}
        }
    },
    components: {
        "my-board-list": MyBoardList,
        "my-board-read": MyBoardRead,
        "my-board-write": MyBoardWrite,
    },
    methods: {
        loadData: function (e) {
            /* 파일 대화상자에서 선택된 파일 */
            file = e.target.files[0];
            if (file) {
                let reader = new FileReader();
                let vm = this;
                /* 파일 읽기 함수 */
                reader.readAsText(file);
                reader.onload = function (e) {
                    vm.dataArray = JSON.parse(e.target.result);
                }
                reader.onloadend = function (e) {
                    /* 데이터 건수가 1개 이상이면 보여주기 */
                    if (vm.dataArray != null &&
                        vm.dataArray["board"].length > 0) {
                        vm.listOk = true;
                    }
                    else {
                        vm.listOk = false;
                    }
                }
            }
        },
        /* 글 목록이 보임 */
        boardList: function () {
            this.readOk = false;
            this.writeOk = false;
            this.listOk = true;
        },
        /* 글 상세보기 */
        boardRead: function (info) {
            this.readOk = true
            this.writeOk = false
            this.listOk = false
            this.boardInfo = info
            /* 해당 글을 찾아서 view 카운트를 올려줌 */
            for (i in this.dataArray["board"]) {
                /* 클릭한 객체의 번호와 같은 배열의 값에 처리를 해줌 */
                if (this.dataArray["board"][i].no == info.no) {
                    this.dataArray["board"][i].view = parseInt(this.dataArray["board"][i].view) + 1
                }
            }
        },
        /* 새글 쓰기 */
        boardWrite: function () {
            this.readOk = false;
            this.writeOk = true;
            this.listOk = false;
        },
        /* 글쓰기저장 */
        boardSave: function (title, content) {
            let no = 1

            /* 배열의 마지막 인덱스 넘버를 찾아 거기에 1을 더해줌 */
            let maxindex = this.dataArray["board"].length - 1
            if (this.dataArray["board"].length != 0) {
                no = parseInt(this.dataArray["board"][maxindex].no) + 1
            }

            /* 새로운 객체(새 글) 생성 */
            let board_info = {
                no: no,
                title: title,
                content: content,
                view: "1"
            }
            this.dataArray["board"].push(board_info);

            /* 새글을 저장했으므로 다시 목록으로 돌아감 */
            this.readOk = false;
            this.writeOk = false;
            this.listOk = true;
        },
        boardDelete: function (no) {
            /* 해당 글을 찾아서 지운당 */
            for (i in this.dataArray["board"]) {
                /* 클릭한 객체의 번호와 같은 배열의 값에 처리를 해줌 */
                if (this.dataArray["board"][i].no == no) {
                    /* splice(지울인덱스 위치, 인덱스부터 삭제할 개수) */
                    this.dataArray["board"].splice(i, 1);
                }
            }
        },


    }
})