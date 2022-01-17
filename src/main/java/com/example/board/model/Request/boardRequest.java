package com.example.board.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class boardRequest {

    private String boardTitle;

    private String createDt;

    private String updateDt;

    private String boardContents;

    private boolean isDelete;

}




