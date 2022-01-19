package com.example.board.repository;

import com.example.board.model.Entity.memberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface memberRepository extends JpaRepository<memberEntity, Integer> {}
