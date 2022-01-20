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
        boardEntity.setBoardIdx(request.getBoardIdx());
        boardEntity.setBoardContents(request.getBoardContents());
        boardEntity.setBoardTitle(request.getBoardTitle());
        boardEntity.setCreateDt(request.getCreateDt());
        boardEntity.setUpdateDt(request.getUpdateDt());
        boardEntity.setBoardIsDelete(request.getBoardIsDelete());

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
        if(request.getBoardIdx() != null) {
            boardEntity.setBoardIdx(request.getBoardIdx());
        }
        if(request.getBoardTitle() != null) {
            boardEntity.setBoardTitle(request.getBoardTitle());
        }

        if(request.getBoardContents() != null) {
            boardEntity.setBoardContents(request.getBoardContents());
        }

        if(request.getCreateDt() != null) {
            boardEntity.setCreateDt(request.getCreateDt());
        }

        if(request.getUpdateDt() != null) {
            boardEntity.setUpdateDt(request.getUpdateDt());
        }

        if(request.getBoardIsDelete() != null) {
            boardEntity.setBoardIsDelete(request.getBoardIsDelete());
        }

        return this.boardRepository.save(boardEntity);
    }

    @Transactional
    public List<boardEntity> deleteById(Integer idx) {
        this.boardRepository.deleteById(idx);
        return boardRepository.findAll();
    }

    public void deleteAll() {
        this.boardRepository.deleteAll();
    }
}