package com.example.board.model.Response;

import com.example.board.model.Entity.boardEntity;

public class attachmentResponse {
    private int attachmentNo;
    private String attachmentNickname;
    private String attachmentPw;
    private String attachmentContent;
    private String attachmentUrl;

    public attachmentResponse(boardEntity) {
        this.attachmentNo = boardEntity.getattachmentNo();
        this.attachmentNickname = boardEntity.getattachmentNickname();
        this.attachmentPw = boardEntity.getattachmentPw();
        this.attachmentContent = boardEntity.getattachmentContent();

        this.attachmentUrl = "http://localhost:8080/" + this.attachmentNo;

    }
}
