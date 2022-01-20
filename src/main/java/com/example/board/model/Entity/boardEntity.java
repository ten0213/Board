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
    @Column(nullable = false)
    private int boardIdx;

    @Column
    private String boardTitle;

    @Column
    private LocalDateTime createDt;

    @Column
    private LocalDateTime updateDt;

    @Column(nullable = false)
    private String boardContents;

    @Column
    private Boolean boardIsDelete;
    


}
