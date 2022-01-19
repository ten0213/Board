package com.example.board.controller;

import com.example.board.model.Entity.attachmentEntity;
import com.example.board.model.Entity.memberEntity;
import com.example.board.model.Request.attachmentRequest;
import com.example.board.model.Response.attachmentResponse;
import com.example.board.service.attachmentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.management.ObjectName;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@CrossOrigin
@AllArgsConstructor
@Controller
public class attachmentController {

    private attachmentService attachmentservice;

    @GetMapping(path = "/")
    public String attachment() {
        return "attachment";
    }

    @PostMapping
    public ResponseEntity<attachmentResponse> create(@RequestBody attachmentRequest request) {
        System.out.println("CREATE");
        if(ObjectUtils.isEmpty(request.getAttachmentNickname()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getAttachmentPw()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getAttachmentContent()))
            return ResponseEntity.badRequest().build();

        attachmentEntity result = this.attachmentservice.add(request);
        return ResponseEntity.ok(new attachmentResponse(result));
    }

    @GetMapping(path = "/attachment/{idx}")
    public ResponseEntity<attachmentResponse> readOne(@PathVariable Integer idx) {
        System.out.println("READ ONE");
        attachmentEntity result = this.attachmentservice.searchById(idx);
        return ResponseEntity.ok(new attachmentResponse(result));
    }

    @GetMapping(path = "/attachment")
    public ResponseEntity<List<attachmentResponse>> readAll() {
        System.out.println("READ ALL");
        List<attachmentEntity> list = this.attachmentservice.searchAll();
        List<attachmentResponse> response = list.stream().map(attachmentResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/attachment/{idx}")
    public ResponseEntity<attachmentEntity> update(@PathVariable Integer idx, @RequestBody attachmentRequest request) {
        System.out.println("UPDATE");
        attachmentEntity result = this.attachmentservice.updateById(idx, request);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping(path = "/attachment/{idx}")
    public ResponseEntity<?> deleteOne(@PathVariable Integer idx) {
        System.out.println("DELETE ONE");
        List<attachmentEntity> result = attachmentservice.deleteById(idx);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/")
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL");
        this.attachmentservice.deleteAll();
        return ResponseEntity.ok().build();
    }

}
