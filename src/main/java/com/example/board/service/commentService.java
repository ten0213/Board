package com.example.board.service;

import com.example.board.repository.boardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

class commentService {
    private final com.example.board.repository.boardRepository boardrepository;

    public BoardEntity.boardEntity add(BoardRequest.boardRequest request) {
        BoardEntity.boardEntity boardEntity = new BoardEntity.boardEntity();
        boardEntity.setboardTitle(request.getboardTitle());
        boardEntity.setOrder(request.getOrder());
        boardEntity.setCompleted(request.getCompleted());
        // <S extends T> S save(S entity);
        // save는 제네릭으로 받은 타입(T)으로 값을 반환
        return this.boardRepository.save(boardEntity);
    }
    //    2	todo  리스트 목록 중 특정 아이템을 조회
    public BoardEntity searchById(Long id) {
        return  this.boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    //    3	todo 리스트 전체 목록을 조회
    public List<BoardEntity> searchAll() {
        return this.boardrepository.findAll();
    }
    //    4	todo 리스트 목록 중 특정 아이템을 수정
    public BoardEntity updateById(Long id, BoardRequest request) {
        BoardEntity boardEntity = this.searchById(id);
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

