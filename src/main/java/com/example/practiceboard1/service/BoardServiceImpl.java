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

import javax.swing.text.html.Option;
import java.util.Arrays;
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
    public List<Board> getList() {
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    @Override
    public BoardDTO getBoard(Long bno) {
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

    @Override
    public Long registerBoard(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        Long bno = boardRepository.save(board).getBno();
        return bno;
    }

    @Override
    public void updateBoard(BoardDTO boardDTO) {
       Board oldBoard = boardRepository.findById(boardDTO.getBno()).get();
       oldBoard.setTitle(boardDTO.getTitle());
       oldBoard.setContent(boardDTO.getContent());
       oldBoard.setWriter(boardDTO.getWriter());
       boardRepository.save(oldBoard);

    }

    @Override
    public void deleteBoard(Long bno) {
        boardRepository.deleteById(bno);

    }

//    @Override
//    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
//        String[] types = pageRequestDTO.getTypes();
//        String keyword = pageRequestDTO.getKeyword();
//        Pageable pageable=pageRequestDTO.getPageable("bno");
//
//        //Page<Board> result = boardRepository.findAll(pageable);
//        Page<Board> result = boardRepository.searchAll( keyword, pageable);
//
//        List<BoardDTO> dtoList=result.getContent().stream()
//                .map(board -> modelMapper.map(board, BoardDTO.class))
//                .collect(Collectors.toUnmodifiableList());
//
//        return PageResponseDTO.<BoardDTO>withAll()
//                .pageRequestDTO(pageRequestDTO)
//                .dtoList(dtoList)
//                .total((int)result.getTotalElements())
//                .build();
//    }
}
