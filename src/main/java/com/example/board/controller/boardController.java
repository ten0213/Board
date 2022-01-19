package com.example.board.controller;

import com.example.board.model.Entity.boardEntity;
import com.example.board.model.Request.boardRequest;
import com.example.board.model.Response.boardResponse;
import com.example.board.service.boardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@CrossOrigin
@AllArgsConstructor
@Controller
public class boardController {

    private boardService boardservice;

    @GetMapping(path = "/")
    public String board() {
        return "board";
    }

    @PostMapping
    public ResponseEntity<boardResponse> create(@RequestBody boardRequest request) {
        System.out.println("CREATE");
        if(ObjectUtils.isEmpty(request.getBoardTitle()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getBoardContent()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getCreateDt()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getUpdateDt()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getIsDelete()))
            request.setIsDelete(false);

        boardEntity result = this.boardservice.add(request);
        return ResponseEntity.ok(new boardResponse(result));
    }

    @GetMapping(path = "/board/{idx}")
    public ResponseEntity<boardResponse> readOne(@PathVariable Integer idx) {
        System.out.println("READ ONE");
        boardEntity result = this.boardservice.searchById(idx);
        return ResponseEntity.ok(new boardResponse(result));
    }

    @GetMapping(path = "/board")
    public ResponseEntity<List<boardResponse>> readAll() {
        System.out.println("READ ALL");
        List<boardEntity> list = this.boardservice.searchAll();
        List<boardResponse> response = list.stream().map(boardResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/board/{idx}")
    public ResponseEntity<boardEntity> update(@PathVariable Integer idx, @RequestBody boardRequest request) {
        System.out.println("UPDATE");
        boardEntity result = this.boardservice.updateById(idx, request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/board/{idx}")
    public ResponseEntity<?> deleteOne(@PathVariable Integer idx) {
        System.out.println("DELETE ONE");
        List<boardEntity> result = boardservice.deleteById(idx);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/")
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL");
        this.boardservice.deleteAll();
        return ResponseEntity.ok().build();
    }


}



