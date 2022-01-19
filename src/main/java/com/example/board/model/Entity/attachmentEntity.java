package com.example.board.model.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class attachmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachmentId;

    @Column(nullable = false)
    private String attachmentNickname;

    @Column(nullable = false)
    private String attachmentPw;

    @Column(nullable = false)
    private String attachmentContent;


}
