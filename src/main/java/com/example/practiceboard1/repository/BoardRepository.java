package com.example.practiceboard1.repository;

import com.example.practiceboard1.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
