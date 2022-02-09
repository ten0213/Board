<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
</head>
<body>
            <h2 style="text-align: center">게시글 및 댓글 조회 페이지</h2>
            <form style="text-align: center">
                글제목
                <label>
                    <input type="text" name="boardTitle" value="게시판 운영 시작" size="82" style="text-align: center">
                </label><br><br>
                작성자
                <label>
                    <input type="text" name="writer" value="관리자" size="82" style="text-align: center">
                </label><br><br>
                작성일자
                <label>
                    <input type="text" name="createDT" value="2022-01-22" size="80" style="text-align: center">
                </label><br><br>
                <label>
                    <textarea name="boardContent" rows="30" cols="100">내용</textarea>
                </label><br><br>

            </form>
            <button type="button">목록으로</button>
            <button type="button">수정</button>
            <button type="button">삭제</button>
            <br><br>
            <form id="boardForm" name="boardForm">
                <table>
                    <thead id="thead">
                    </thead>
                    <tbody id="tbody">
                    </tbody>
                </table>
            </form>
            <br><br>
            전체 댓글
            <hr>
            닉네임: <input type="text" name="userName"> <br>
            비밀번호: <input type="password" name="userPassword"><br>
            <label>댓글:
               <br> <br>  &nbsp;&nbsp;<textarea name="comment" rows="9" cols="100"></textarea>
            </label>


            <br>

            <input type="submit" value="등록" onclick="alert('댓글이 등록되었습니다!')" style="float:right">

</body>

</html>