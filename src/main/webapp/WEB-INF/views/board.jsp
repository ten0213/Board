<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 메인 페이지</title>
    <script>


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
            fetch("/board", {
                method: "GET",
                headers: {
                    "Content-Type": "application.json",
                }
            })
                .then((res) => res.json())
                .then((res) => initBoardList(res));
        }



        const initBoardList = (boardList) => {
            const list = document.getElementsByClassName("boardData");
            for(let i = 0; i <boardList.length; i++) {
                const li = document.createElement("li");
                list.appendChild(li);
            }
        }
    </script>


</head>
<body>
<h2 style="text-align: center">게시판 메인 페이지</h2><br>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>2</td>
            <td>안녕하세요</td>
            <td>홍길동</td>
            <td>2022-01-13</td>
        </tr>
        <tr>
            <td>1</td>
            <td>게시판 운영 시작</td>
            <td>관리자</td>
            <td>2022-01-12</td>
        </tr>
        </tbody>
    </table>
    <div style="float:right">
        <button type="button" style="text-align:right">글쓰기</button>
    </div>

        <ul class="pagination modal">
            <li> <a href="#" class="first">처음 페이지</a></li>
            <li> <a href="#" class="arrow left"><<</a></li>
            <li> <a href="#" class="active num">1</a></li>
            <li> <a href="#" class="num">2</a></li>
            <li> <a href="#" class="num">3</a></li>
            <li> <a href="#" class="num">4</a></li>
            <li> <a href="#" class="num">5</a></li>
            <li> <a href="#" class="num">6</a></li>
            <li> <a href="#" class="num">7</a></li>
            <li> <a href="#" class="num">8</a></li>
            <li> <a href="#" class="num">9</a></li>
            <li> <a href="#" class="arrow right">>></a></li>
            <li><a href="#" class="last">끝 페이지</a></li>
        </ul>
    </div>
</body>

<ul id="boardData"></ul>


</html>