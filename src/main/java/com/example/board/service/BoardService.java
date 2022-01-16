package com.example.board.service;

import com.example.board.model.BoardEntity;
import com.example.board.model.BoardRequest;
import com.example.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository todoRepository;

    //    1	todo 리스트 목록에 아이템을 추가
    public BoardEntity add(BoardRequest request) {
        BoardEntity todoEntity = new BoardEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());
        // <S extends T> S save(S entity);
        // save는 제네릭으로 받은 타입(T)으로 값을 반환
        return this.todoRepository.save(todoEntity);
    }
    //    2	todo  리스트 목록 중 특정 아이템을 조회
    public BoardEntity searchById(Long id) {
        return  this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    //    3	todo 리스트 전체 목록을 조회
    public List<BoardEntity> searchAll() {
        return this.todoRepository.findAll();
    }
    //    4	todo 리스트 목록 중 특정 아이템을 수정
    public BoardEntity updateById(Long id, BoardRequest request) {
        BoardEntity todoEntity = this.searchById(id);
        if(request.getTitle() != null) {
            todoEntity.setTitle(request.getTitle());
        }
        if(request.getOrder() != null) {
            todoEntity.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null) {
            todoEntity.setCompleted(request.getCompleted());
        }
        return this.BoardRepository.save(BoardEntity);
    }


    //    5	todo 리스트 목록 중 특정 아이템을 삭제
    @Transactional
    public List<BoardEntity> deleteById(Long id) {
        this.todoRepository.deleteById(id);
        return todoRepository.findAll();
    }
    //    6	todo 리스트 전체 목록을 삭제
    public void deleteAll() {
        this.todoRepository.deleteAll();
    }
}
