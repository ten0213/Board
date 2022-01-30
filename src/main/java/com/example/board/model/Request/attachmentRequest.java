package com.example.board.model.Request;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class attachmentRequest {

    private Integer attachmentIdx;

    private String attachmentNickname;

    private String attachmentPath;

    private String attachmentLength;

    private String attachmentUrl;

    private Boolean attachmentIsDelete;

}
