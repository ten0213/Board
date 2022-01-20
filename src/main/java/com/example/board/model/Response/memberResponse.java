package com.example.board.model.Response;

import com.example.board.model.Entity.boardEntity;
import com.example.board.model.Entity.memberEntity;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class memberResponse {
    private Integer memberIdx;
    private String memberName;
    private String memberPw;
    private String memberUrl;


    public memberResponse(memberEntity memberentity) {
        this.memberIdx = memberentity.getMemberIdx();
        this.memberName = memberentity.getMemberName();
        this.memberPw = memberentity.getMemberIP();

        this.memberUrl = "http://localhost:8080/" + this.memberIdx;
    }
}