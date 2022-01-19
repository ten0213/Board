package com.example.board.model.Response;

import com.example.board.model.Entity.attachmentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class attachmentResponse {
    private int attachmentId;
    private String attachmentNickname;
    private String attachmentPw;
    private String attachmentContent;
    private String attachmentUrl;



    public attachmentResponse(attachmentEntity attachmententity) {
        this.attachmentId = attachmententity.getAttachmentId();
        this.attachmentNickname = attachmententity.getAttachmentNickname();
        this.attachmentPw = attachmententity.getAttachmentPw();
        this.attachmentContent = attachmententity.getAttachmentContent();

        this.attachmentUrl = "http://localhost:8080/" + this.attachmentId;

    }
}
