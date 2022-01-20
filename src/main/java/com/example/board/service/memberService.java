package com.example.board.service;

import com.example.board.model.Entity.memberEntity;

import com.example.board.model.Request.memberRequest;
import com.example.board.repository.memberRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class memberService {
    private final memberRepository memberRepository;

    public memberService(com.example.board.repository.memberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public memberEntity add(memberRequest request) {
        memberEntity memberEntity = new memberEntity();
        memberEntity.setMemberIdx(request.getMemberIdx());
        memberEntity.setMemberName(request.getMemberName());
        memberEntity.setMemberIP(request.getMemberIP());

        return this.memberRepository.save(memberEntity);
    }
    public memberEntity searchById(Integer idx) {
        return this.memberRepository.findById(idx)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    //    3	todo 리스트 전체 목록을 조회


    public List<memberEntity> searchAll() {
        return this.memberRepository.findAll();
    }
    //    4	todo 리스트 목록 중 특정 아이템을 수정
    public memberEntity updateById(Integer idx, memberRequest request) {
        memberEntity memberEntity = this.searchById(idx);
        if(request.getMemberIdx() != null) {
            memberEntity.setMemberIdx(request.getMemberIdx());
        }
        if(request.getMemberName() != null) {
            memberEntity.setMemberName(request.getMemberName());
        }
        if(request.getMemberIP() != null) {
            memberEntity.setMemberIP(request.getMemberIP());
        }
        return this.memberRepository.save(memberEntity);
    }


    //    5	todo 리스트 목록 중 특정 아이템을 삭제
    @Transactional
    public List<memberEntity> deleteById(Integer idx) {
        this.memberRepository.deleteById(idx);
        return memberRepository.findAll();
    }
    //    6	todo 리스트 전체 목록을 삭제
    public void deleteAll() {
        this.memberRepository.deleteAll();
    }
}
