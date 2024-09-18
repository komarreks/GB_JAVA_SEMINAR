package ru.gb.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book findBookById(long id){
        return bookRepository.getBookById(id);
    }

    public boolean deleteBookById(long id){
        return bookRepository.deleteById(id);
    }

    public Book createBook(Book book){
        Book findedBook = bookRepository.getBooks().stream()
                .filter(b -> b.getName().equals(book.getName()))
                .findFirst().orElse(null);

        if (findedBook == null){
            findedBook = new Book(book.getName());
            bookRepository.addBook(findedBook);
        }

        return findedBook;
    }

    public List<Book> getAll(){
        return bookRepository.getBooks();
    }
}
