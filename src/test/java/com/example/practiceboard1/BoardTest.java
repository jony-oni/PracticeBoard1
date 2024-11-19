package com.example.practiceboard1;

import com.example.practiceboard1.domain.Board;
import com.example.practiceboard1.dto.BoardDTO;
import com.example.practiceboard1.dto.PageRequestDTO;
import com.example.practiceboard1.dto.PageResponseDTO;
import com.example.practiceboard1.service.BoardService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        log.info(boardService.getClass().getName());
        BoardDTO boardDTO = BoardDTO.builder()
                .title("Sample title2")
                .content("Sample Content2")
                .writer("Sample User2")
                .build();
        Long bno = boardService.registerBoard(boardDTO);
        log.info("bno:" + bno);
    }

    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(52L)
                .title("title_modify")
                .content("content_modify")
                .writer("writer_modify")
                .build();
        boardService.updateBoard(boardDTO);
    }

    //@Test
//    public void testList(){
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .type("tcw")
//                .keyword("title")
//                .page(1)
//                .size(8)
//                .build();
//        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
//
//    }



}
