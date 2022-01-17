package com.example.board.model.Response;

import com.example.board.model.Entity.boardEntity;

public class commentResponse {
    private int commentNo;
    private String commentName;
    private String commentPw;
    private String commentContent;
    private String commentUrl;

    private commentResponse(boardEntity) {
        this.commentNo = boardEntity.getcommentNo();
        this.commentName = boardEntity.getcommentName();
        this.commentPw = boardEntity.getcommentPw();
        this.commentContent = boardEntity.getcommentContent();

        this.commentUrl = "http://localhost:8080/" + this.commentNo;
    }

}