package com.example.practiceboard1.controller;

import com.example.practiceboard1.domain.Board;
import com.example.practiceboard1.service.BoardService;
import groovy.util.logging.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("boardList",boardService.getList());
    }

    @GetMapping("/register")
    public void registerGet(){

    }
    @PostMapping("/register")
    public String registerPost(Board board){
        boardService.registerBoard(board);
        return "redirect:/board/list";
    }

    @GetMapping({"/read","modify"})
    public void read(Long bno, Model model){
        model.addAttribute("dto",boardService.getBoard(bno));
    }

    @PostMapping("/modify")
    public String modify(Board board, RedirectAttributes redirectAttributes){
        boardService.updateBoard(board);
        redirectAttributes.addAttribute("bno",board.getBno());
        return "redirect:/board/read";
    }

    @PostMapping("/remove")
    public String remove(Board board){
        boardService.deleteBoard(board.getBno());
        return "redirect:/board/list";
    }
}