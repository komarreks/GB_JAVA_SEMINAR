package ru.gb.springdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id){
        Book book = bookService.findBookById(id);

        if (book != null){
            return ResponseEntity.status(HttpStatus.OK).body(book);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id){
        if (bookService.deleteBookById(id)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAll());
    }
}
