package ru.gb.springdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.service.ReaderService;

import java.util.List;

@RestController
@RequestMapping("api/reader")
public class ReaderController {

    @Autowired
    ReaderService readerService;

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReader(@PathVariable long id){
        Reader reader = readerService.getReaderById(id);

        if (reader != null) return ResponseEntity.status(HttpStatus.OK).body(reader);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reader> deleteReader(@PathVariable long id){
        if (readerService.deleteReaderById(id)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Reader> createReader(@RequestBody Reader reader){
        return ResponseEntity.status(HttpStatus.CREATED).body(readerService.createReader(reader));
    }

    @GetMapping("/{id}/issue")
    public ResponseEntity<List<Issue>> getAllIssues(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(readerService.getAllIssues(readerService.getReaderById(id)));
    }
}
