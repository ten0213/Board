package com.example.board.model.Request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class boardRequest {

    private Long boardIdx;

    private String boardTitle;

    private String writer;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;

    private String boardContent;

    private Boolean isDelete;

}




