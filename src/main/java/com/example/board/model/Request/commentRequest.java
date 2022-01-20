package com.example.board.model.Request;


import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class commentRequest {

    private Integer commentIdx;

    private String commentContent;

    private LocalDateTime commentCreateDt;

    private LocalDateTime commentUpdateDt;

    private Boolean commentIsDelete;

    private Integer commentPw;

    private Integer memberIdx;
}
