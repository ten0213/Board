package com.example.board.service;

import com.example.board.model.Entity.attachmentEntity;
import com.example.board.model.Request.attachmentRequest;
import com.example.board.repository.attachmentRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class attachmentService {
    private final attachmentRepository attachmentRepository;

    public attachmentEntity add(attachmentRequest request) {
        attachmentEntity attachmentEntity = new attachmentEntity();
        attachmentEntity.setAttachmentNickname(request.getAttachmentNickname());
        attachmentEntity.setAttachmentLength(request.getAttachmentLength());
        attachmentEntity.setAttachmentUrl(request.getAttachmentUrl());
        attachmentEntity.setAttachmentIsDelete(request.getAttachmentIsDelete());

        return this.attachmentRepository.save(attachmentEntity);
    }

    public attachmentEntity searchById(Integer idx) {
        return this.attachmentRepository.findById(idx)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<attachmentEntity> searchAll() {
        return this.attachmentRepository.findAll();
    }

    public attachmentEntity updateById(Integer idx, attachmentRequest request) {
        attachmentEntity attachmentEntity = this.searchById(idx);

        if(request.getAttachmentNickname() != null) {
            attachmentEntity.setAttachmentNickname(request.getAttachmentNickname());
        }

        if (request.getAttachmentLength() != null) {
            attachmentEntity.setAttachmentLength(request.getAttachmentLength());
        }

        if(request.getAttachmentUrl() != null) {
            attachmentEntity.setAttachmentUrl(request.getAttachmentUrl());
        }
        if(request.getAttachmentIsDelete() != null) {
            attachmentEntity.setAttachmentIsDelete(request.getAttachmentIsDelete());
        }

        return this.attachmentRepository.save(attachmentEntity);
    }

    @Transactional
    public List<attachmentEntity> deleteById(Integer idx) {
        this.attachmentRepository.deleteById(idx);
        return attachmentRepository.findAll();
    }

    public void deleteAll() {
        this.attachmentRepository.deleteAll();
    }
}
