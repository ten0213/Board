package com.example.board.controller;

import com.example.board.model.Entity.attachmentEntity;
import com.example.board.model.Request.attachmentRequest;
import com.example.board.model.Response.attachmentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

public class attachmentController {

    private com.example.board.service.attachmentService attachmentService;

    @GetMapping(path = "/")
    public String attachment() {
        return "/attachment";
    }

    @PostMapping
    public ResponseEntity<attachmentResponse> create(@RequestBody attachmentRequest request) {
        System.out.println("CREATE");

        if(ObjectUtils.isEmpty(request.getAttachmentNickname()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getAttachmentLength()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getAttachmentUrl()))
            return ResponseEntity.badRequest().build();

        if(ObjectUtils.isEmpty(request.getAttachmentIsDelete()))
            request.setAttachmentIsDelete(false);

        attachmentEntity result = this.attachmentService.add(request);
        return ResponseEntity.ok(new attachmentResponse(result));
    }

    @GetMapping
    public ResponseEntity<attachmentResponse> readOne(@PathVariable Integer idx) {
        System.out.println("READ ONE");
        attachmentEntity result = this.attachmentService.searchById(idx);
        return ResponseEntity.ok(new attachmentResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<attachmentResponse>> readAll() {
        System.out.println("READ ALL");
        List<attachmentEntity> list = this.attachmentService.searchAll();
        List<attachmentResponse> response = list.stream().map(attachmentResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping
    public ResponseEntity<attachmentEntity> update(@PathVariable Integer idx, @RequestBody attachmentRequest request) {
        System.out.println("UPDATE");
        attachmentEntity result = this.attachmentService.updateById(idx, request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteOne(@PathVariable Integer idx) {
        System.out.println("DELETE ONE");
        List<attachmentEntity> result = attachmentService.deleteById(idx);
        return ResponseEntity.ok(result);
    }

    /*@DeleteMapping(path = "/")
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL");
        this.attachmentService.deleteAll();
        return ResponseEntity.ok().build();
    }*/
}
