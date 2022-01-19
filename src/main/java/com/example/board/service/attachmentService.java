package com.example.board.service;

import com.example.board.model.Entity.attachmentEntity;
import com.example.board.model.Request.attachmentRequest;
import com.example.board.repository.attachmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class attachmentService {
    private final attachmentRepository attachmentRepository;

    public attachmentService(com.example.board.repository.attachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }


    public attachmentEntity add(attachmentRequest request) {
        attachmentEntity attachmentEntity = new attachmentEntity();
        attachmentEntity.setAttachmentNickname(request.getAttachmentNickname());
        attachmentEntity.setAttachmentPw(request.getAttachmentPw());
        attachmentEntity.setAttachmentContent(request.getAttachmentContent());


        // <S extends T> S save(S entity);
        // save는 제네릭으로 받은 타입(T)으로 값을 반환
        return this.attachmentRepository.save(attachmentEntity);
    }
    //    2	todo  리스트 목록 중 특정 아이템을 조회
    public attachmentEntity searchById(Integer idx) {
        return this.attachmentRepository.findById(idx)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }


    public List<attachmentEntity> searchAll() {
        return this.attachmentRepository.findAll();
    }
    //    4	todo 리스트 목록 중 특정 아이템을 수정
    public attachmentEntity updateById(Integer idx, attachmentRequest request) {

        attachmentEntity attachmentEntity = this.searchById(idx);
        if(request.getAttachmentNickname() != null) {
            attachmentEntity.setAttachmentNickname(request.getAttachmentNickname());
        }
        if(request.getAttachmentPw() != null) {
            attachmentEntity.setAttachmentPw(request.getAttachmentPw());
        }
        if(request.getAttachmentContent() != null) {
            attachmentEntity.setAttachmentContent(request.getAttachmentContent());
        }
        return this.attachmentRepository.save(attachmentEntity);
    }


    //    5	todo 리스트 목록 중 특정 아이템을 삭제
    @Transactional
    public List<attachmentEntity> deleteById(Integer id) {
        this.attachmentRepository.deleteById(id);
        return attachmentRepository.findAll();
    }
    //    6	todo 리스트 전체 목록을 삭제
    public void deleteAll() {
        this.attachmentRepository.deleteAll();
    }
}