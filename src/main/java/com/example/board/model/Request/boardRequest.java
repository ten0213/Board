package com.example.board.model.Request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class boardRequest {

    private Integer boardIdx;

    private String boardTitle;


    private LocalDateTime createDt;

    private LocalDateTime updateDt;

    private String boardContents;

    private Boolean boardIsDelete;

    private Integer memberIdx;

    private Integer commentIdx;

    private Integer attachmentIdx;

}




