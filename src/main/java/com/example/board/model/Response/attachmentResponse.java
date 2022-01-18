package com.example.board.model.Response;

import com.example.board.model.Entity.attachmentEntity;

public class attachmentResponse {
    private int attachmentNo;
    private String attachmentNickname;
    private String attachmentPw;
    private String attachmentContent;
    private String attachmentUrl;



    public attachmentResponse(attachmentEntity attachmententity) {
        this.attachmentNo = attachmententity.getAttachmentNo();
        this.attachmentNickname = attachmententity.getAttachmentNickname();
        this.attachmentPw = attachmententity.getAttachmentPw();
        this.attachmentContent = attachmententity.getAttachmentContent();

        this.attachmentUrl = "http://localhost:8080/" + this.attachmentNo;

    }
}
