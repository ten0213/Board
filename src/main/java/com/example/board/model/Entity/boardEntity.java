package com.example.board.model.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class boardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNo;

    @Column(nullable = false)
    private String boardTitle;

    @Column(nullable = false)
    private String createDt;

    @Column(nullable = false)
    private String updateDt;

    @Column(nullable = false)
    private String boardContent;

    @Column(nullable = false)
    private int memberNo;

    @Column(nullable = false)
    private String commentNo;

    @Column(nullable = false)
    private String attachmentNo;

    @Column(nullable = false)
    private boolean isDelete;

    public static boolean getisDelete() {
    }


    public String getBoardTitle() {
        return boardTitle;
    }

    public String getCreateDt() {
        return createDt;
    }

    public String getUpdateDt() {
        return updateDt;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public String getCommentNo() {
        return commentNo;
    }

    public String getAttachmentNo() {
        return attachmentNo;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public int getBoardNo() {
        return boardNo;
    }


    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public void setCommentNo(String commentNo) {
        this.commentNo = commentNo;
    }

    public void setAttachmentNo(String attachmentNo) {
        this.attachmentNo = attachmentNo;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
