package com.example.board.repository;

import com.example.board.model.Entity.commentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository extends JpaRepository<commentEntity, Integer> {
}
