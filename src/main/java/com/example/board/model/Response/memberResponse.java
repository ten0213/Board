package com.example.board.model.Response;

import com.example.board.model.Entity.boardEntity;

public class memberResponse {
    private int memberNo;
    private String memberName;
    private String memberPw;
    private String memberUrl;

    public memberResponse(boardEntity) {
        this.memberNo = boardEntity.getmemberId();
        this.memberName = boardEntity.getmemberName();
        this.memberPw = boardEntity.getmemberPw();

        this.memberUrl = "http://localhost:8080/" + this.memberNo;
    }
}