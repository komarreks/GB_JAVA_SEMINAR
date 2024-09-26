package ru.gb.springdemo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.IssueRepository;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderService {

    @Autowired
    ReaderRepository readerRepository;
    @Autowired
    IssueRepository issueRepository;

    @Autowired
    BookService bookService;

    @PostConstruct
    private void firstInit(){
        if (readerRepository.findAll().size() == 0){
            readerRepository.save(new Reader("Иван Иванов"));
            readerRepository.save(new Reader("Петр Петров"));
            readerRepository.save(new Reader("Сергей Сергеев"));
            readerRepository.save(new Reader("Маркиз Де Сад"));
        }

    }

    public Reader getReaderById(long id){
        return readerRepository.getById(id);
    }

    public boolean deleteReaderById(long id) {
        Reader reader = getReaderById(id);
        if (reader != null){
            readerRepository.delete(reader);
            return true;
        }
        return false;
    }

    public Reader createReader(Reader reader) {
        Reader newReader = new Reader(reader.getName());
        readerRepository.save(newReader);
        return newReader;
    }

    public List<Issue> getAllIssues(Reader reader){
        return issueRepository.findByReader(reader);
    }

    public List<Reader> getAllReaders(){
        return readerRepository.findAll();
    }

    public List<Book> allBooksOnHands(Reader reader){
        List<Issue> issues = issueRepository.findByReader(reader).stream().filter(i -> i.getReturned_at() == null).toList();

        List<Book> booksOnHands = new ArrayList<>();

        for (Issue issue: issues) {
            booksOnHands.add(bookService.findBookById(issue.getBook().getId()));
        }

        return booksOnHands;
    }
}
