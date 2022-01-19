package com.example.board.service;

import java.util.List;

import com.example.board.model.Entity.boardEntity;
import com.example.board.model.Request.boardRequest;
import com.example.board.repository.boardRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class boardService {
    private final boardRepository boardRepository;

    // 게시판 목록에 게시글을 추가
    public boardEntity add(boardRequest request) {
        boardEntity boardEntity = new boardEntity();
        boardEntity.setBoardContent(request.getBoardContent());
        boardEntity.setWriter(request.getWriter());
        boardEntity.setBoardTitle(request.getBoardTitle());
        boardEntity.setCreateDt(request.getCreateDt());
        boardEntity.setUpdateDt(request.getUpdateDt());

        return this.boardRepository.save(boardEntity);
    }

    public boardEntity searchById(Integer idx) {
        return this.boardRepository.findById(idx)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<boardEntity> searchAll() {
        return this.boardRepository.findAll();
    }

    public boardEntity updateById(Integer idx, boardRequest request) {
        boardEntity boardEntity = this.searchById(idx);
        if(request.getBoardTitle() != null) {
            boardEntity.setBoardTitle(request.getBoardTitle());
        }

        if(request.getBoardContent() != null) {
            boardEntity.setBoardContent(request.getBoardContent());
        }

        if(request.getWriter() != null) {
            boardEntity.setWriter(request.getWriter());
        }
        if(request.getCreateDt() != null) {
            boardEntity.setCreateDt(request.getCreateDt());
        }

        if(request.getUpdateDt() != null) {
            boardEntity.setUpdateDt(request.getUpdateDt());
        }

        return this.boardRepository.save(boardEntity);
    }

    @Transactional
    public List<boardEntity> deleteById(Integer id) {
        this.boardRepository.deleteById(id);
        return boardRepository.findAll();
    }

    public void deleteAll() {
        this.boardRepository.deleteAll();
    }
}