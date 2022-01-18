package com.example.board.model.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class attachmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachmentNo;

    @Column(nullable = false)
    private String attachmentNickname;

    @Column(nullable = false)
    private String attachmentPw;

    @Column(nullable = false)
    private String attachmentContent;

    public int getAttachmentNo() {
        return attachmentNo;
    }

    public String getAttachmentNickname() {
        return attachmentNickname;
    }

    public String getAttachmentPw() {
        return attachmentPw;
    }

    public String getAttachmentContent() {
        return attachmentContent;
    }


    public void setAttachmentNo(int attachmentNo) {
        this.attachmentNo = attachmentNo;
    }

    public void setAttachmentNickname(String attachmentNickname) {
        this.attachmentNickname = attachmentNickname;
    }

    public void setAttachmentPw(String attachmentPw) {
        this.attachmentPw = attachmentPw;
    }

    public void setAttachmentContent(String attachmentContent) {
        this.attachmentContent = attachmentContent;
    }

}
