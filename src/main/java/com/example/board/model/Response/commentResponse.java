package com.example.board.model.Response;

import com.example.board.model.Entity.attachmentEntity;
import com.example.board.model.Entity.commentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class commentResponse {


    private Integer commentIdx;
    private String commentContent;
    private LocalDateTime commentCreateDt;
    private LocalDateTime commentUpdateDt;
    private Boolean commentIsDelete;
    private Integer commentPw;
    private Integer memberIdx;

    private String commentUrl;




    public commentResponse(commentEntity commentEntity) {
        this.commentIdx = commentEntity.getCommentIdx();
        this.commentContent = commentEntity.getCommentContent();
        this.commentPw = commentEntity.getCommentPw();
        this.commentCreateDt = commentEntity.getCommentCreateDt();
        this.commentUpdateDt = commentEntity.getCommentUpdateDt();

        this.commentUrl = "http://localhost:8080/" + this.commentIdx;

    }
}
