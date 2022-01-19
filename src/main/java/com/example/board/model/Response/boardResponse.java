package com.example.board.model.Response;


import com.example.board.model.Entity.boardEntity;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class boardResponse {

    private Long boardIdx;
    private String boardTitle;
    private String createDt;
    private String updateDt;
    private String boardContent;
    private int memberNo;
    private int commentNo;
    private int attachmentNo;
    private Boolean isDelete;
    private String writer;
    private String boardUrl;

    public boardResponse(boardEntity boardentity) {
        this.boardIdx = (long) boardentity.getBoardIdx();
        this.boardTitle = boardentity.getBoardTitle();
        this.createDt = String.valueOf(boardentity.getCreateDt());
        this.updateDt = String.valueOf(boardentity.getUpdateDt());
        this.boardContent = boardentity.getBoardContent();
        this.memberNo = boardentity.getMemberIdx();
        this.commentNo = Integer.parseInt(boardentity.getCommentIdx());
        this.attachmentNo = Integer.parseInt(boardentity.getAttachmentIdx());
        this.isDelete = Boolean.parseBoolean(String.valueOf(boardentity.getIsDelete()));
        this.writer = boardentity.getWriter();
        this.boardUrl = "http://localhost:8080/" + this.boardIdx;
    }




}
