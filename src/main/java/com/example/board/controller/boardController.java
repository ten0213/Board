package com.example.board.controller;

import com.example.board.model.Entity.boardEntity;
import com.example.board.model.Response.boardResponse;
import com.example.board.service.boardService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

public class boardController {
    private  boardService boardservice;

    @GetMapping(path = "/")
    public String board() {
        return "board";
    }

    @PostMapping
    public ResponseEntity<boardResponse> create(@RequestBody BoardRequest.boardRequest request) {
        System.out.println("CREATE");
        if (ObjectUtils.isEmpty(request.getboardTitle()))
            return ResponseEntity.badRequest().build();

        if (ObjectUtils.isEmpty(request.getOrder()))
            request.setOrder(0L);

        if (ObjectUtils.isEmpty(request.getCompleted()))
            request.setCompleted(false);

        BoardEntity.boardEntity result = this.boardservice.add(request);
        return ResponseEntity.ok(new boardResponse.boardResponse(result));
    }

    @GetMapping(path = "/todo/{id}")
    public ResponseEntity<boardResponse.boardResponse> readOne(@PathVariable Long id) {
        System.out.println("READ ONE");
        BoardEntity.boardEntity result = this.boardservice.searchById(id);
        return ResponseEntity.ok(new boardResponse.boardResponse(result));
    }

    @GetMapping(path = "/todolist")
    public ResponseEntity<List<boardResponse>> readAll() {
        System.out.println("READ ALL");
        List<BoardEntity> list = this.boardservice.searchAll();
        List<boardResponse> response = list.stream().map(boardResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/todo/{id}")
    public ResponseEntity<BoardEntity> update(@PathVariable Long id, @RequestBody BoardRequest request) {
        System.out.println("UPDATE");
        BoardEntity result = this.boardservice.updateById(id, request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/todo/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        System.out.println("DELETE ONE");
        List<boardEntity> result = boardservice.deleteById(id);
        return  ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/")
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL");
        this.boardservice.deleteAll();
        return ResponseEntity.ok().build();
    }
}



