package com.example.board.repository;

import com.example.board.model.Entity.boardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface boardRepository extends JpaRepository<boardEntity, Integer> {

}




