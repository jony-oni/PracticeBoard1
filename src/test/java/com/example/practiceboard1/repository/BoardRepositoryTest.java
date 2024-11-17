package com.example.practiceboard1.repository;


import com.example.practiceboard1.domain.Board;
import groovy.util.logging.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1, 30).forEach(i -> {
            Board board = Board.builder()
                    .title("Sample Title"+i)
                    .content("Sample Content"+i)
                    .writer("Sample User"+i)
                    .postdate(LocalDateTime.now())
                    .build();
            Board result = boardRepository.save(board);
        });

    }

    @Test
    public void testSelect(){
        Long bno = 30L;
        Optional<Board>result = boardRepository.findById(bno);
        Board board = result.orElseThrow();

    }

}
