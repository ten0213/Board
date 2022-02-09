package com.example.board.model.Response;


import com.example.board.model.Entity.boardEntity;
import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class boardResponse {

    private Integer boardIdx;
    private String boardTitle;
    private Timestamp createDt;
    private Timestamp updateDt;
    private String boardContents;
    private Boolean boardIsDelete;
    private Integer memberIdx;
    private Integer commentIdx;
    private Integer attachmentIdx;

    private String boardUrl;

    public boardResponse(boardEntity boardentity) {
        this.boardIdx = boardentity.getBoardIdx();
        this.boardTitle = boardentity.getBoardTitle();
        this.createDt = boardentity.getCreateDt();
        this.updateDt = boardentity.getUpdateDt();
        this.boardContents = boardentity.getBoardContents();
        this.boardIsDelete = boardentity.getBoardIsDelete();

        this.boardUrl = "http://localhost:8080/" + this.boardIdx;
    }




}
