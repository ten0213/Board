package com.example.board.controller;

import com.example.board.model.Entity.boardEntity;
import com.example.board.model.Request.boardRequest;
import com.example.board.model.Response.boardResponse;
import com.example.board.service.boardService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@CrossOrigin
@AllArgsConstructor
@Controller
public class boardController {


    private boardService boardservice;

    @RequestMapping(value = "/board/boardList") //게시글 목록
    public String boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "mainpage";
    }
    @GetMapping(path = "/")
    public String board() {
        return "board";
    }

    @PostMapping(path = "/board/createBoard")
    public ResponseEntity<boardResponse> create(@RequestBody boardRequest request) {
        System.out.println("CREATE");

        if(ObjectUtils.isEmpty(request.getBoardIdx()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getBoardTitle()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getBoardContents()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getCreateDt()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getUpdateDt()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getBoardIsDelete()))
            request.setBoardIsDelete(false);

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

    @RequestMapping("/boardUpdate?boardNo={boardNo}")
    public String update(HttpServletRequest request, HttpServletResponse response, @PathVariable String boardNo) throws Exception {

        return "updatepage";
    }


    @DeleteMapping(path = "/board/{idx}")
    public ResponseEntity<?> deleteOne(@PathVariable Integer idx) {
        System.out.println("DELETE ONE");
        List<boardEntity> result = boardservice.deleteById(idx);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value="/boardWrite")
    public String boardWrite() throws Exception {
        return "/boardWrite";
    }

}



