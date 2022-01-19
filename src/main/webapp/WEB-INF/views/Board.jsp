
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        body {
            margin: 0;
            min-width: 250px;
        }
        * {
            box-sizing: border-box;
        }
        ul li {
            cursor: pointer;
            position: relative;
            padding: 12px 8px 12px 40px;
            list-style-type: none;
            background: #eee;
            font-size: 18px;
            transition: 0.2s;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }
        ul li:nth-child(odd) {
            background: #f9f9f9;
        }
        ul li:hover {
            background: #ddd;
        }
        .close {
            position: absolute;
            right: 0;
            top: 0;
            padding: 12px 16px 12px 16px;
        }
        .close:hover {
            background-color: #f44336;
            color: white;
        }
        .header {
            background-color: #f44336;
            padding: 30px 40px;
            color: white;
            text-align: center;
        }
        .header:after {
            content: "";
            display: table;
            clear: both;
        }
        input {
            margin: 0;
            border: none;
            border-radius: 0;
            width: 75%;
            padding: 10px;
            float: left;
            font-size: 16px;
        }
        .addBtn {
            padding: 10px;
            width: 13%;
            background: #d9d9d9;
            color: #555;
            float: left;
            text-align: center;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
            border-radius: 0;
        }
        .addBtn:hover {
            background-color: #bbb;
        }
    </style>
    <title>todolist</title>
</head>
<body>

<div id="myDIV" class="header">
    <h2 style="margin:5px">My first project : ToDo List</h2>
    <label for="myInput"></label>
    <input type="text" id="myInput" placeholder="Title...">

    <span onclick="newElement()" class="addBtn">Add</span>

</div>



<ul id="myExistData">

</ul>


<script>

    let myNodeList = document.getElementsByTagName("li");
    var i;
    for (i = 0; i < myNodeList.length; i++) {
        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        myNodeList[i].appendChild(span);
    }


    var close = document.getElementsByClassName("close");
    var i;
    for (i = 0; i < close.length; i++) {
        close[i].onclick = function () {
            const div = this.parentElement;
            div.style.display = "none";
        }
    }


    var updateList = document.createElement("updateButton");
    var i;
    for (i = 0; i < updateList.length; i++) {
        var txt_update = document.createTextNode("edit");
        var SPAN = document.createElement("myExistData");
        SPAN.className = "update";
        SPAN.appendChild(txt_update);
        updateList[i].appendChild();
    }



    function newElement() {
        const inputValue = document.getElementById("myInput").value;
        fetch("/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: inputValue,
                order: 1,
                completed: true
            }),
        })
            .then((res) => res.json())
            .then((response) => {
                const li = document.createElement("li");
                li.innerText = response.title;
                if (inputValue === '') {
                    alert("You must write something!");
                } else {
                    document.getElementById("myExistData").appendChild(li);
                }
                const span = document.createElement("SPAN");
                span.onclick = function () {
                    fetch("/board/" + response.id, {
                        method: "DELETE",
                        headers: {
                            "Content-Type": "application/json",
                        }
                    })
                        .then((res) => res.json())
                        .then((res) => {
                            removeTodo(res);
                        });
                }
                const txt = document.createTextNode("\u00D7");
                span.className = "close";
                span.appendChild(txt);
                li.appendChild(span);
            });

        /*for (i = 0; i < close.length; i++) {
            close[i].onclick = function () {
                const div = this.parentElement;
                div.style.display = "none";
            }
        }*/
    }


    window.onload = function () {
        fetch("/board", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            }
        })
            .then((res) => res.json())
            .then((res) => initTodoList(res));
    }


    const initTodoList = (todolist) => {
        const list = document.getElementById("myExistData");
        for (let i = 0; i < todolist.length; i++) {
            const li = document.createElement("li");
            li.innerText = todolist[i].title;
            const span = document.createElement("span");
            span.onclick = function () {
                fetch("/board/" + todolist[i].id, {
                    method: "DELETE",
                    headers: {
                        "Content-Type": "application/json",
                    }
                })
                    .then((res) => res.json())
                    .then((res) => {
                        removeTodo(res);
                    });
            }
            const txt = document.createTextNode("\u00D7");
            span.className = "close";
            span.appendChild(txt);
            li.appendChild(span);
            list.appendChild(li);
        }
    }


    const removeTodo = function (res) {
        removeTodolist();
        initTodoList(res);
    }


    const removeTodolist = () => {
        const li_get = document.getElementById('myExistData');
        while (li_get.hasChildNodes()) {
            li_get.removeChild(li_get.firstChild);
        }
    }


    //끝


    // update(수정)함수 정의
    function editElement() {
        const editValue = document.getElementById("myExistData").value;
        fetch("/board/{id}", {
            method: "UPDATE",
            headers: {
                "Content-Type": "application/json",
            }
            /*body: JSON.stringify({
                title: editValue,
                order: 1,
                completed: true
            }),*/
        })
            .then((res) => res.json())
            .then((response) => {
                const edit = document.createElement("edit");
                edit.innerText = response.title;
                document.getElementById("myExistData").appendChild(edit);

                const txt = document.createTextNode("edit");
                span.className = "edit";
                span.appendChild(txt);
                editValue.appendChild(span);
            });

        for (i = 0; i < close.length; i++) {
            editValue[i].onclick = function () {
                const u = this.parentElement;
                u.style.display = "none";
            }
        }
    }



</script>
</body>
</html>



<!--게시판 메인 페이지(Board.jsp)





<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/Board.css">
    <title>Notice Board</title>
</head>
<body>
<div class="container">
    <div class="row">
        <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
            <thead>
            <tr>
                <th style="background-color: #eeeeee; text-align: center;">번호</th>
                <th style="background-color: #eeeeee; text-align: center;">제목</th>
                <th style="background-color: #eeeeee; text-align: center;">작성자</th>
                <th style="background-color: #eeeeee; text-align: center;">작성일</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>안녕하세요</td>
                <td>홍길동</td>
                <td>2017-05-04</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>