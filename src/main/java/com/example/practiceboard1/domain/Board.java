package com.example.practiceboard1.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="practice_board")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,length = 1024)
    private String content;

    @Column(nullable = false,length = 50)
    private String writer;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime postdate;

}