package ru.gb.springdemo.controllers;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springdemo.service.BookService;
import ru.gb.springdemo.service.IssuerService;
import ru.gb.springdemo.service.ReaderService;


@Controller
@RequestMapping("/ui")
@RequiredArgsConstructor
public class PagesController {

    private final BookService bookService;
    private final ReaderService readerService;
    private final IssuerService issuerService;

    @GetMapping("/books")
    public String allBooks(Model md){

        md.addAttribute("books", bookService.getAll());

        return "books";
    }

    @GetMapping("/readers")
    public String allReaders(Model md){
        md.addAttribute("readers", readerService.getAllReaders());

        return "readers";
    }

    @GetMapping("/issues")
    public String allIssues(Model md){
        md.addAttribute("issues", issuerService.allIssuesDTO());

        return "issues";
    }

    @GetMapping("/reader/{id}")
    public String allBooksOfReader(@PathVariable long id, Model md){
        md.addAttribute("reader", readerService.getReaderById(id).getName());
        md.addAttribute("books", readerService.allBooksOnHands(readerService.getReaderById(id)));

        return "reader";
    }
}
