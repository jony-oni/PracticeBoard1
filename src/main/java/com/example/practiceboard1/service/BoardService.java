package com.example.practiceboard1.service;

import com.example.practiceboard1.domain.Board;
import com.example.practiceboard1.dto.BoardDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BoardService {
    List<Board> getList();
    Board getBoard(Long bno);
    void registerBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Long bno);

    //PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
