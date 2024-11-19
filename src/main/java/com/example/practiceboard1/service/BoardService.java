package com.example.practiceboard1.service;

import com.example.practiceboard1.domain.Board;
import com.example.practiceboard1.dto.BoardDTO;
import com.example.practiceboard1.dto.PageRequestDTO;
import com.example.practiceboard1.dto.PageResponseDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BoardService {
    List<Board> getList();
    BoardDTO getBoard(Long bno);
    Long registerBoard(BoardDTO boardDTO);
    void updateBoard(BoardDTO boardDTO);
    void deleteBoard(Long bno);
   // PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
