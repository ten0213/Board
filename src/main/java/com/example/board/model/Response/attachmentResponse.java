package com.example.board.model.Response;

import com.example.board.model.Entity.attachmentEntity;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class attachmentResponse {

    private int attachmentIdx;

    private String attachmentNickname;

    private String attachmentLength;

    private Boolean attachmentIsDelete;

    private String attachmentUrl;

    public attachmentResponse(attachmentEntity attachmentEntity) {
        this.attachmentIdx = attachmentEntity.getAttachmentIdx();
        this.attachmentNickname = attachmentEntity.getAttachmentNickname();
        this.attachmentLength = attachmentEntity.getAttachmentLength();
        this.attachmentIsDelete = attachmentEntity.getAttachmentIsDelete();
        this.attachmentUrl = "http://localhost:8080/" + this.attachmentIdx;
    }
}
