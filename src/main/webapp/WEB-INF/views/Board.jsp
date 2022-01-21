<!--게시판 메인 페이지(Board.jsp)-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    function newElement() {
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
    }
</script>
</body>
</html>