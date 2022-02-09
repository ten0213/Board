<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="en">
<head>
    <meta charset = 'utf-8'>
    <title>게시판 작성 페이지</title>
</head>
<script>
    /** 게시판 - 목록 페이지 이동 */
    function goBoardList(){
        location.href = "/";
    }

    /* 게시판 작성 함수  */
    function insertBoard() {
        const boardTitle = $("#board_title").val(); //게시글 제목
        const boardContent = $("#board_contents").val(); //게시글 내용
        const userName = $("#member_name").val(); //작성자


        if (boardTitle === ""){
            alert("입력되지 않은 정보가 있습니다.");
            $("#boardTitle").focus();
            return;
        }

        if (boardContent === ""){
            alert("입력되지 않은 정보가 있습니다.");
            $("#boardContent").focus();
            return;
        }

        if (userName === ""){
            alert("입력되지 않은 정보가 있습니다.");
            $("#userName").focus();
            return;
        }




        var yn = confirm("게시글을 등록하시겠습니까?");
        if(yn){

            let filesChk = $("input[name='files[0]']").val();
            if(filesChk === ""){
                $("input[name='file[0]']").remove();
            }

            $("#boardForm").ajax({

                url        : "/board/boardWrite",
                enctype    : "multipart/form-data",
                cache   : false,
                async   : true,
                type    : "POST",
                success : function(obj) {
                    insertBoardCallback(obj);
                },
                error : function (xhr, status, error) {}
            }).submit();
        }
    }

    /* 게시판 -  callback */
    function insertBoardCallback(obj) {

        if(obj != null){

            let result = obj.result;

            if(result === "SUCCESS"){
                alert("게시글 등록을 성공하였습니다.");
                goBoardList();

            } else {
                alert("다시 입력해주세요");
            }
        }
    }


    function checkFile(el) {


        let file = el.files;


        if (file[0].size > 1024 * 1024 * 30) {


            alert('30MB 이하 파일만 등록할 수 있습니다.\n\n' + '현재파일 용량 : ' + (Math.round(file[0].size / 1024 / 1024 * 100) / 100) + 'MB');
        }
        const inputFile = document.getElementById("files");
        const video = document.getElementById("video");
        inputFile.addEventListener("change", function () {
            const file = inputFile.files[0];
            const videoUrl = URL.createObjectURL(file);
            video.setAttribute("src", videoUrl);
            video.play();
        })
    }
    function btn_cancel(){
        if (confirm("게시글 작성을 취소하시겠습니까?")) {
            {
                alert("게시글 작성이 취소되었습니다.");
                goBoardList();
            }
        }
    }

</script>
<style>
    table.table2{
        border-collapse: separate;
        border-spacing: 1px;
        text-align: left;
        line-height: 1.5;
        border-top: 1px solid #ccc;
        margin : 20px 10px;
    }
    table.table2 tr {
        width: 50px;
        padding: 10px;
        font-weight: bold;
        vertical-align: top;
        border-bottom: 1px solid #ccc;
    }
    table.table2 td {
        width: 100px;
        padding: 10px;
        vertical-align: top;
        border-bottom: 1px solid #ccc;
    }

</style>
<body>
<div id="wrap">
    <div id="container">
        <div class="inner">
            <h1>게시글 작성</h1>
            <form id="boardForm" name="boardForm" enctype="multipart/form-data" method="post" onsubmit="return false;">
                작성자: <input type="text" name="board_writer">
            </form>
            <br>
            제목: <input type="text" name="board_title">
            <br><br> 내용: <Br>
            <textarea name="board_contents" rows="30" cols="100"></textarea>
            <br><br>
            <form method="post" enctype="multipart/form-data">
                <div>
                    <input type="file" name="fileNo" id="files" accept="image/png, image/jpg, image/jpeg, image/gif, video/mp4, video/avi" onchange="checkFile(this)">
                </div>
            </form>
            <form action="board.jsp" method="get">
            <button type="button" class="create_button_cancel" onclick="btn_cancel()">취소</button>
        </form>
            <button type="button" class="create_button_upload" onclick="insertBoard();">등록</button>
        </div>
    </div>
</div>
<%--<form method="get">
    <table  style="padding-top:50px">
        <tr>
            <td height=20 align= center bgcolor=#ccc><font color=white>게시판 글쓰기 양식</font></td>
        </tr>
        <tr>
            <td>
                <table class = "table2">

                    <tr>
                        <td>제목</td>
                        <td><label>
                            <input type = text name = boardTitle size=60>
                        </label></td>
                    </tr>

                    <tr>
                        <td>내용</td>
                        <td><label>
                            <textarea name=boardContent content cols=85 rows=15></textarea>
                        </label></td>
                    </tr>

                </table> <br>

                <form method="POST" enctype="multipart/form-data">
                    파일 첨부<input type="file" id="files[0]" name="files[0]" value=""><br/>
                    <br/>
                    <input type="submit" value="작성" style="float: right;" onclick="location.href='/board'">
                </form>
            </td></tr>

    </table>

</form>--%>
</body>
</html>
