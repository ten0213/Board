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
}
