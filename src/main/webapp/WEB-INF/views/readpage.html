<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <script>


        $(document).ready(function(){
            getBoardDetail();
        });



        /** 게시판 - 목록 페이지 이동 */
        function goBoardList(){
            location.href = "/board/boardList";
        }

        /** 게시판 조회에서 게시글 수정을 위해 본인확인 페이지로 이동**/
        function getIdentificationForUpdate(){
            location.href ="identification_update.jsp";
        }



        function fileDownload(fileNameKey, fileName, filePath){

            location.href = "/board/fileDownload?fileNameKey="+fileNameKey+"&fileName="+fileName+"&filePath="+filePath;
        }

        /** 게시판 - 상세 조회  */
        function getBoardDetail(boardNo){

            var boardNo = $("#board_idx").val();

            if(boardNo !== ""){

                $.ajax({

                    url        : "/board/boardDetail?boardNo="+ boardNo,

                    data    : $("#boardForm").serialize(),
                    dataType: "JSON",
                    cache   : false,
                    async   : true,
                    type    : "POST",

                    success : function(obj) {
                        getBoardDetailCallback(obj);
                    },
                    error     : function(xhr, status, error) {}

                });
            } else {
                alert("오류가 발생했습니다.\n관리자에게 문의하세요.");
            }
        }

        /** 게시판 - 상세 조회  콜백 함수 */
        function getBoardDetailCallback(obj){

            var str = "";

            if(obj != null){

                var boardTitle         = obj.boardTitle; //게시판 제목
                var boardContent         = obj.boardContent; //게시판 내용
                var boardWriteUpdate     = obj.createDT; //새로운 작성일자
                var boardDeleted     = obj.boardIsDelete; //게시글 삭제 여부
                var userName            = obj.userName; //작성자명


                str += "<tr>";
                str += "<th>제목</th>";
                str += "<td>"+ boardTitle +"</td>";
                str += "</tr>";

                str += "<tr>";
                str += "<th>작성자</th>";
                str += "<td>"+ userName +"</td>";
                str += "<th>작성일시</th>";
                str += "<td>"+ boardWriteDate +"</td>";


                str += "<tr>";
                str += "<th>내용</th>";
                str += "<td colspan='3'>"+ boardContent +"</td>";
                str += "</tr>";

                let filesLen;
                if(filesLen > 0){

                    for(var a=0; a<filesLen; a++){


                        var fileNameKey = files[a].file_name_key;
                        var fileName     = files[a].file_name;
                        var filePath     = files[a].file_path;


                        str += "<th>첨부파일</th>";

                        str += "<td colspan='3'><a href='/board/fileDownload?fileNameKey="+encodeURI(fileNameKey)+"&fileName="+encodeURI(fileName)+"&filePath="+encodeURI(filePath)+"'>" + fileName + "</a></td>";
                        str += "</tr>";
                    }
                }

            } else {

                alert("등록된 글이 존재하지 않습니다.");
                return;
            }

            $("#tbody").html(str);
        }


    </script>
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