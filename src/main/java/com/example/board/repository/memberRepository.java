package com.example.board.repository;

import com.example.board.model.Entity.boardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface memberRepository extends JpaRepository<boardEntity,Long> {
}
