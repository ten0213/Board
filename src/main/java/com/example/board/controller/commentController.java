package com.example.board.controller;

import com.example.board.model.Entity.commentEntity;
import com.example.board.model.Request.commentRequest;
import com.example.board.model.Response.commentResponse;
import com.example.board.service.commentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@CrossOrigin
@AllArgsConstructor
@Controller
public class commentController {

    private commentService commentService;




    public ResponseEntity<commentResponse> create(@RequestBody commentRequest request) {
        System.out.println("CREATE");
        if(ObjectUtils.isEmpty(request.getCommentIdx()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getCommentCreateDt()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getCommentUpdateDt()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getCommentIsDelete()))
            return ResponseEntity.badRequest().build();

       if(ObjectUtils.isEmpty(request.getCommentPw()))
           return  ResponseEntity.badRequest().build();

        commentEntity result = this.commentService.add(request);
        return ResponseEntity.ok(new commentResponse(result));
    }


    public ResponseEntity<commentResponse> readOne(@PathVariable Integer idx) {
        System.out.println("READ ONE");
        commentEntity result = this.commentService.searchById(idx);
        return ResponseEntity.ok(new commentResponse(result));
    }



        System.out.println("READ ALL");
        List<commentEntity> list = this.commentService.searchAll();
        List<commentResponse> response = list.stream().map(commentResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);



    public ResponseEntity<commentEntity> update(@PathVariable Integer idx, @RequestBody commentRequest request) {
        System.out.println("UPDATE");
        commentEntity result = this.commentService.updateById(idx, request);
        return ResponseEntity.ok(result);
    }


    public ResponseEntity<?> deleteOne(@PathVariable Integer idx) {
        System.out.println("DELETE ONE");
        List<commentEntity> result = commentService.deleteById(idx);
        return ResponseEntity.ok(result);
    }


}
