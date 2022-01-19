package com.example.board.model.Entity;

import lombok.Data;

import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
public class boardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardIdx;

    @Column(nullable = false)
    private String boardTitle;

    @Column(nullable = false)
    private LocalDateTime createDt;

    @Column(nullable = false)
    private LocalDateTime updateDt;

    @Column(nullable = false)
    private String boardContent;

    @Column(nullable = false)
    private Boolean isDelete;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private int memberIdx;

    @Column(nullable = false)
    private String commentIdx;

    @Column(nullable = false)
    private String attachmentIdx;


}
