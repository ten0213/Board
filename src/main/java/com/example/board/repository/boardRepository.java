package com.example.board.repository;

import com.example.board.model.Entity.boardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface boardRepository extends JpaRepository<boardEntity, Long> {}


