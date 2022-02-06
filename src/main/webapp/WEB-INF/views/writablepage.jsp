<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="en">
<head>
    <meta charset = 'utf-8'>
    <title>게시판 작성 페이지</title>
</head>
<script>
    /*function goBoardList(){
        location.href = "";
    }
    function insertBoardData() {
        let boardTitle = $("#boardTitle").val();
        let boardContent = $("#boardContent").val();
        let member_name = $("#member_name").val();


        if (boardTitle === "") {
            alert("입력된 값이 존재하지 않습니다.");
            $("#boardTitle").focus();
            return;
        }

        if(boardContent === "") {
            alert("입력된 값이 존재하지 않습니다.");
            $("#boardContent").focus();
            return;
        }

        if(member_name === "") {
            alert("입력된 값이 존재하지 않습니다.");
            $("#member_name").focus();
            return;
        }
    }*/

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
<form method="get">
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
                    <input type="submit" value="작성" style="float: right;">
                </form>

    </table>

</form>
</body>
</html>
