package com.example.board.model.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class attachmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachmentIdx;

    @Column(nullable = false)
    private String attachmentNickname;

    @Column(nullable = false)
    private String attachmentLength;

    @Column(nullable = false)
    private String attachmentUrl;

    @Column(nullable = false)
    private Boolean attachmentIsDelete;

    @Column(nullable = false)
    private String attachmentPath;

}
