package com.example.practiceboard1.service;

import com.example.practiceboard1.domain.Board;
import com.example.practiceboard1.dto.BoardDTO;
import com.example.practiceboard1.dto.PageRequestDTO;
import com.example.practiceboard1.dto.PageResponseDTO;
import com.example.practiceboard1.repository.BoardRepository;
import groovy.util.logging.Log4j2;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final ModelMapper   modelMapper;



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

    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
        Pageable pageable=pageRequestDTO.getPageable("bno");
        //Page<Board> result = boardRepository.findAll(pageable);
        Page<Board> result = boardRepository.searchAll(pageRequestDTO.getKeyword(),pageable);
        List<BoardDTO> dtoList=result.getContent().stream()
                .map(board -> modelMapper.map(board, BoardDTO.class))
                .collect(Collectors.toUnmodifiableList());
        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }
}
