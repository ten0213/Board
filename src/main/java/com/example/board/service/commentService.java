package com.example.board.service;


import com.example.board.model.Entity.commentEntity;
import com.example.board.model.Request.commentRequest;
import com.example.board.repository.commentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class commentService {
    private final commentRepository commentRepository;

    public commentEntity add(commentRequest request) {
        commentEntity commentEntity = new commentEntity();
        commentEntity.setCommentIdx(request.getCommentIdx());
        commentEntity.setCommentContent(request.getCommentContent());
        commentEntity.setCommentCreateDt(request.getCommentCreateDt());
        commentEntity.setCommentUpdateDt(request.getCommentUpdateDt());
        commentEntity.setCommentPw(request.getCommentPw());
        commentEntity.setCommentIsDelete(request.getCommentIsDelete());

        return this.commentRepository.save(commentEntity);
    }
    //    2	todo  리스트 목록 중 특정 아이템을 조회
    public commentEntity searchById(Integer idx) {
        return this.commentRepository.findById(idx)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }


    public List<commentEntity> searchAll() {
        return this.commentRepository.findAll();
    }
    //    4	todo 리스트 목록 중 특정 아이템을 수정
    public commentEntity updateById(Integer idx, commentRequest request) {

        commentEntity commentEntity = this.searchById(idx);
        if(request.getCommentIdx() != null) {
            commentEntity.setCommentIdx(request.getCommentIdx());
        }
        if(request.getCommentContent() != null) {
            commentEntity.setCommentContent(request.getCommentContent());
        }
        if(request.getCommentCreateDt() != null) {
            commentEntity.setCommentCreateDt(request.getCommentCreateDt());
        }

        if(request.getCommentIsDelete() != null) {
            commentEntity.setCommentIsDelete(request.getCommentIsDelete());
        }
        if(request.getCommentPw() != null) {
            commentEntity.setCommentPw(request.getCommentPw());
        }

        return this.commentRepository.save(commentEntity);
    }


    //    5	todo 리스트 목록 중 특정 아이템을 삭제
    @Transactional
    public List<commentEntity> deleteById(Integer id) {
        this.commentRepository.deleteById(id);
        return commentRepository.findAll();
    }
    //    6	todo 리스트 전체 목록을 삭제
    public void deleteAll() {
        this.commentRepository.deleteAll();
    }
}