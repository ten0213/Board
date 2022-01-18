package com.example.board.model.Response;


import com.example.board.model.Entity.boardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class boardResponse {

    private Long boardNo;
    private String boardTitle;
    private String createDt;
    private String updateDt;
    private String boardContent;
    private int memberNo;
    private int commentNo;
    private int attachmentNo;
    private boolean isDelete;
    private String boardUrl;

    public boardResponse(boardEntity boardentity) {
        this.boardNo = (long) boardentity.getBoardNo();
        this.boardTitle = boardentity.getBoardTitle();
        this.createDt = boardentity.getCreateDt();
        this.updateDt = boardentity.getUpdateDt();
        this.boardContent = boardentity.getBoardContent();
        this.memberNo = boardentity.getMemberNo();
        this.commentNo = Integer.parseInt(boardentity.getCommentNo());
        this.attachmentNo = Integer.parseInt(boardentity.getAttachmentNo());
        this.isDelete = boardentity.getIsDelete();

        this.boardUrl = "http://localhost:8080/" + this.boardNo;
    }




}
