package com.example.board.model.Response;

import com.example.board.model.Entity.boardEntity;
import com.example.board.model.Entity.memberEntity;

public class memberResponse {
    private int memberNo;
    private String memberName;
    private String memberPw;
    private String memberUrl;




    public memberResponse(memberEntity memberentity) {
        this.memberNo = memberentity.getMemberNo();
        this.memberName = memberentity.getMemberName();
        this.memberPw = memberentity.getMemberPw();

        this.memberUrl = "http://localhost:8080/" + this.memberNo;
    }
}