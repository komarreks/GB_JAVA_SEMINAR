package ru.gb.springdemo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @PostConstruct
    private void firstInit(){
        if (bookRepository.findAll().size() == 0){
            bookRepository.save(new Book("Война и мир"));
            bookRepository.save(new Book("Идиот"));
            bookRepository.save(new Book("Хороший код"));
            bookRepository.save(new Book("Анна Каренина"));
        }
    }

    public Book findBookById(long id){
        return bookRepository.findById(id);
    }

    public boolean deleteBookById(long id){
        Book book = findBookById(id);

        if (book == null) return false;
        bookRepository.delete(book);
        return true;
    }

    public Book createBook(Book book){
        Book findedBook = bookRepository.findAll().stream()
                .filter(b -> b.getName().equals(book.getName()))
                .findFirst().orElse(null);

        if (findedBook == null){
            findedBook = new Book(book.getName());
            bookRepository.save(findedBook);
        }

        return findedBook;
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }
}
