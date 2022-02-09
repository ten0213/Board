package com.example.board.model.Entity;

import lombok.Data;

import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
public class boardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int boardIdx;

    @Column
    private String boardTitle;

    @Column
    private Timestamp createDt;

    @Column
    private Timestamp updateDt;

    @Column(nullable = false)
    private String boardContents;

    @Column
    private Boolean boardIsDelete;

    @Column(nullable = false)
    private String memberName;

    @ManyToOne
    @JoinColumn(name = "memberIdx")
    private memberEntity memberEntity;

    @ManyToOne
    @JoinColumn(name = "attachmentIdx")
    private attachmentEntity attachmentEntity;

    @ManyToOne
    @JoinColumn(name = "commentIdx")
    private commentEntity commentEntity;


}
