package com.example.board.controller;

import com.example.board.model.Entity.memberEntity;
import com.example.board.model.Request.memberRequest;
import com.example.board.model.Response.memberResponse;
import com.example.board.service.memberService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@CrossOrigin
@AllArgsConstructor
@Controller
public class memberController {

    private memberService memberservice;

    public String member() {
        return "member";
    }


    public ResponseEntity<memberResponse> create(@RequestBody memberRequest request) {
        System.out.println("CREATE");

        if(ObjectUtils.isEmpty(request.getMemberName()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getMemberIP()))
            return ResponseEntity.badRequest().build();

        memberEntity result = this.memberservice.add(request);
        return ResponseEntity.ok(new memberResponse(result));
    }


    public ResponseEntity<memberResponse> readOne(@PathVariable Integer idx) {
        System.out.println("READ ONE");
        memberEntity result = this.memberservice.searchById(idx);
        return ResponseEntity.ok(new memberResponse(result));
    }


    public ResponseEntity<List<memberResponse>> readAll() {
        System.out.println("READ ALL");
        List<memberEntity> list = this.memberservice.searchAll();
        List<memberResponse> response = list.stream().map(memberResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);

    }


    public ResponseEntity<memberEntity> update(@PathVariable Integer idx, @RequestBody memberRequest request) {
        System.out.println("UPDATE");
        memberEntity result = this.memberservice.updateById(idx, request);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> deleteOne(@PathVariable Integer idx) {
        System.out.println("DELETE ONE");
        List<memberEntity> result = memberservice.deleteById(idx);
        return ResponseEntity.ok(result);
    }

    /*@DeleteMapping(path = "/")
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL");
        this.memberservice.deleteAll();
        return ResponseEntity.ok().build();
    }*/

}
