package com.example.board.model.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class memberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private String memberPw;
}
