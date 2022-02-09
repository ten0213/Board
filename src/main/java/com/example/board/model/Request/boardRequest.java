package com.example.board.model.Request;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class boardRequest {

    private Integer boardIdx;

    private String boardTitle;


    private Timestamp createDt;

    private Timestamp updateDt;

    private String boardContents;

    private Boolean boardIsDelete;

    private Integer memberIdx;

    private Integer commentIdx;

    private Integer attachmentIdx;

    private String memberName;

}




