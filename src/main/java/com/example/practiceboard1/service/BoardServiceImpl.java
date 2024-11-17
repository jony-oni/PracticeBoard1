package com.example.practiceboard1.service;

import com.example.practiceboard1.domain.Board;
import com.example.practiceboard1.dto.BoardDTO;
import com.example.practiceboard1.repository.BoardRepository;
import groovy.util.logging.Log4j2;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public List<Board> getList() {
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    @Override
    public Board getBoard(Long bno) {
       return boardRepository.findById(bno).get();
    }

    @Override
    public void registerBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void updateBoard(Board board) {
        Board oldBoard = boardRepository.findById(board.getBno()).get();
        oldBoard.setTitle(board.getTitle());
        oldBoard.setContent(board.getContent());
        oldBoard.setWriter(board.getWriter());
        boardRepository.save(oldBoard);

    }

    @Override
    public void deleteBoard(Long bno) {
        boardRepository.deleteById(bno);

    }
}
