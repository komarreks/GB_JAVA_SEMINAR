package ru.gb.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderService {

    @Autowired
    ReaderRepository readerRepository;
    @Autowired
    IssuerService issuerService;

    @Autowired
    BookService bookService;

    public Reader getReaderById(long id){
        return readerRepository.getReaderById(id);
    }

    public boolean deleteReaderById(long id) {
        return readerRepository.deleteBookById(id);
    }

    public Reader createReader(Reader reader) {
        Reader newReader = new Reader(reader.getName());
        readerRepository.addReader(newReader);
        return newReader;
    }

    public List<Issue> getAllIssues(long readerId){
        return issuerService.allReaderIssues(readerId);
    }

    public List<Reader> getAllReaders(){
        return readerRepository.getReaders();
    }

    public List<Book> allBooksOnHands(long readerId){
        List<Issue> issues = issuerService.allReaderIssues(readerId).stream().filter(i -> i.getReturned_at() == null).toList();

        List<Book> booksOnHands = new ArrayList<>();

        for (Issue issue: issues) {
            booksOnHands.add(bookService.findBookById(issue.getBookId()));
        }

        return booksOnHands;
    }
}
