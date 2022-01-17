package com.example.board.model.Request;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class commentRequest {

    private int commentNo;

    private String commentName;

    private String commentPw;

    private String commentContent;
}
