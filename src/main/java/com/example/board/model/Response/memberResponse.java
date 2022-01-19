package com.example.board.model.Response;

import com.example.board.model.Entity.boardEntity;
import com.example.board.model.Entity.memberEntity;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class memberResponse {
    private int memberId;
    private String memberName;
    private String memberPw;
    private String memberUrl;


    public memberResponse(memberEntity memberentity) {
        this.memberId = memberentity.getMemberId();
        this.memberName = memberentity.getMemberName();
        this.memberPw = memberentity.getMemberPw();

        this.memberUrl = "http://localhost:8080/" + this.memberId;
    }
}