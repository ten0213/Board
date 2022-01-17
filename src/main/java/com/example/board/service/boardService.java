package com.example.board.service;

import com.example.board.model.Entity.BoardEntity;

import com.example.board.model.Request.BoardRequest;

import com.example.board.repository.boardRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class boardService {
    public boardRepository.boardRepository boardrepository;

    @GetMapping
    public BoardEntity.boardEntity add(BoardRequest.boardRequest request) {
        BoardEntity.boardEntity boardEntity = new BoardEntity.boardEntity();
        boardEntity.setboardTitle(request.getboardTitle());
        boardEntity.setOrder(request.getOrder());
        boardEntity.setCompleted(request.getCompleted());
        // <S extends T> S save(S entity);
        // save는 제네릭으로 받은 타입(T)으로 값을 반환
        return this.boardrepository.save(boardEntity);
    }
    //    2	todo  리스트 목록 중 특정 아이템을 조회
    public BoardEntity.boardEntity searchById(Long id) {
        return  this.boardrepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    //    3	todo 리스트 전체 목록을 조회
    public List<BoardEntity.boardEntity> searchAll() {
        return this.boardrepository.findAll();
    }
    //    4	todo 리스트 목록 중 특정 아이템을 수정
    public BoardEntity updateById(Long id, BoardRequest request) {
        BoardEntity.boardEntity boardEntity = this.searchById(id);

        if(request.getTitle() != null) {
            boardEntity.setTitle(request.getTitle());
        }
        if(request.getOrder() != null) {
            boardEntity.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null) {
            boardEntity.setCompleted(request.getCompleted());
        }
        return this.boardrepository.save(boardEntity);
    }


    //    5	todo 리스트 목록 중 특정 아이템을 삭제
    @Transactional
    public List<BoardEntity> deleteById(Long id) {
        this.boardrepository.deleteById(id);
        return boardrepository.findAll();
    }
    //    6	todo 리스트 전체 목록을 삭제
    public void deleteAll() {
        this.boardrepository.deleteAll();
    }


}

