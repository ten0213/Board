package com.example.board.model.Request;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class attachmentRequest {

    private int attachmentIdx;

    private String attachmentNickname;

    private String attachmentPw;

    private String attachmentContent;
}
