<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="ko">
<head>
    <meta charset="UTF-8">


    <title>게시판 메인 페이지</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        thead {
            background-color: lightgrey;
        }
        td, th {
            border: 1px solid lightgray;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
        .center {
            text-align: center;
        }

        .pagination {
            display: inline-block;
        }

        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
        }

        .pagination a.active {
            background-color: #4CAF50;
            color: white;
            border-radius: 5px;
        }

        .pagination a:hover:not(.active) {
            background-color: #ddd;
            border-radius: 5px;
        }
    </style>


</head>
<body>
<h2 style="text-align: center">게시판 메인 페이지</h2><br>
    <form style="text-align: right">
        <label>
            <select name="selection">
                <option value="index">번호</option>
                <option value="title">제목</option>
                <option value="writer">작성자</option>
                <option value="datetime">날짜</option>

                <input type="text" name="id" size="8" style="float:right;"><br>
            </select>
        </label>
    </form>
<form>

</form>

    <table>
        <thead id="thead">
        <tr>
            <th class="index">번호</th>
            <th class="title">제목</th>
            <th class="writer">작성자</th>
            <th class="datetime">날짜</th>
        </tr>
        </thead>
        <tbody id="tbody">

        </tbody>
    </table>
    <div style="float:right">
        <button type="button" class="navyBtn" onclick="location.href='/boardWrite'">글쓰기</button>

    </div><br><br>

<div class="center" >
<div class="pagination" id="pagination">
    <a href="#">&laquo;</a>
    <a href="#"><</a>
    <a href="#" class="active">1</a>
    <a href="#">2</a>
    <a href="#">3</a>
    <a href="#">4</a>
    <a href="#">5</a>
    <a href="#">6</a>
    <a href="#">></a>
    <a href="#">&raquo;</a>
    </div>
</div>
</body>

<script>

    // element 생성하기
    function  createNewElement() {
        const boardList = document.getElementById("myBoardList").value;
        fetch("/", {
            method: "Post",
            headers: {
                "Content-Type": "application.json",
            },
            body: JSON.stringify({
                boardTitle: boardList,
                order: 1,
                boardIsDelete: false
            }),
        })
            .then((res) => res.json())
            .then((response) => {
                const li = document.createElement("li");
                li.value = response.boardTitle;
                document.getElementById("myExistData").appendChild(li);
            })
    }

    // 화면에 표현하기

    window.onload = function () {
        const tbody = document.getElementById("tbody");
        for (let i = 0; i <sample.length; i++) {
            const tr = document.createElement('tr');
            const td1 = document.createElement('td');
            td1.innerText = sample[i].index;
            tr.appendChild(td1);

            const td2 = document.createElement('td');
            const a = document.createElement('a');

            a.innerText = sample[i].title;
            a.href = "/board/boardDetail/"+ sample[i].index;
            td2.appendChild(a);
            tr.appendChild(td2);

            const td3 = document.createElement('td');
            td3.innerText = sample[i].writer;
            tr.appendChild(td3);

            const td4 = document.createElement('td');
            td4.innerText = sample[i].datetime;
            tr.appendChild(td4);

            tbody.appendChild(tr);
        }
    }
    // sample data
    const sample = [
        {
            index: 3,
            title: "hello",
            writer: "관리자",
            datetime: "2022-01-23"
        },
        {
            index: 2,
            title: "hello",
            writer: "김철수",
            datetime: "2022-01-23"
        },
        {
            index: 1,
            title: "hello",
            writer: "김수철",
            datetime: "2022-01-23"
        }
    ]
    function goBoardDetail(boardNo){
        location.href = "/board/boardDetail?boardNo="+ boardNo;
    }

    /* 게시판 - 게시글 검색 */

    function getSearchByUserName(userName){
        location.href = "/boardlist?userName="+ userName;
    }

    /** 게시판 - 작성 페이지 이동 */
    function goBoardWrite(){
        location.href = "/board/createBoard";
    }

    /** 게시판 - 목록 조회  */
    function getBoardList(){
        $.ajax({

            url        :"/boardList",
            //serialize - 데이터를 보내기 위해 form요소 집합을 문자열로 인코딩
            data    : $("#boardForm").serialize(),
            dataType:"JSON",
            cache   : false,
            async   : true,
            type    :"POST",
            success : function(obj) {
                getBoardListCallback(obj);
            },
            error     : function(xhr, status, error) {}

        });
    }

    function getBoardListCallback(obj){

        var state = obj.state;

        if(state === "SUCCESS"){

            var data = obj.data; // 데이터베이스 data
            var list = data.list;// 데이터베이스 data의 list
            var listLen = list.length;// 데이터베이스 data의 list의 length
            var pagination = data.pagination;

            var str = "";

            if(listLen >  0){

                for(var i=0; i<listLen; i++){

                    var boardNo        = list[i].index; //게시글 번호
                    var boardTitle         = list[i].title; //게시글 제목
                    var username        = list[i].writer; //게시글 작성자
                    var boardWriteDate     = list[i].datetime; //게시글 작성 일자

                    str += "<tr>";
                    str += "<td>"+ boardNo +"</td>";

                    str += "<td onclick='goBoardDetail("+ boardNo +");' style='cursor:Pointer'>";


                    str += boardTitle +"</td>"; // 글의 제목

                    str += "<td>"+ username +"</td>"; // 작성자
                    str += "<td>"+ boardWriteDate +"</td>"; // 날짜
                    str += "</tr>";

                }

            } else {

                str += "<tr>";
                str += "<td colspan='5'>등록된 글이 존재하지 않습니다!</td>";
                str += "<tr>";
            }

            $("#tbody").html(str);
            $("#pagination").html(pagination);

        } else {
            alert("관리자에게 문의하세요.");

        }
    }




    /*const initBoardList = (boardList) => {
        const list = document.getElementsByClassName("boardData");
        for(let i = 0; i <boardList.length; i++) {
            const li = document.createElement("li");
            list.appendChild(li);
        }
    }

    const list = document.getElementById('list');

    function drawBoardListView(boardlist) {
        for(let i=0; i<boardlist.length; i++) {
            const tbody = document.createElement('tbody');
            tbody.className = "tbodyClass";


        }
    }*/


</script>

</html>