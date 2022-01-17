package com.example.board.model.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class commentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNo;

    @Column(nullable = false)
    private String commentName;

    @Column(nullable = false)
    private String commentPw;

    @Column(nullable = false)
    private String commentContent;
}
