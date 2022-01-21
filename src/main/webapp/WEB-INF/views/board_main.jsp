<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>게시판 메인 페이지</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="test.css">

</head>
<body>
<h2 style="text-align:center">게시판 메인 페이지</h2><br>
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



    <br><br>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item disabled">
                <a class="page-link">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </nav>
</div>
</body>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="test.css">

<script type="text/javascript" src="js/bootstrap.js"></script>
</html>

<!--게시판 메인 페이지(Board.jsp)-->

<html>
<head>
    <meta charset="UTF-8">
    <title>Notice Board</title>
</head>
<body>
<div class="container">
    <div class="row"></div>
</div>
<ul id="boardData"></ul>
<script>

    /*function newElement() {
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
                const li = document.createElement('li');
                li.value = response.boardTitle;
                document.getElementById("myExistData").appendChild(li);
            })
    }
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
    }*/
</script>
</body>
</html>