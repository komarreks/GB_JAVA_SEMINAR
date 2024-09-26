package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Запись о факте выдачи книги (в БД)
 */
@Data
@Entity
public class Issue {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;
  @ManyToOne
  @JoinColumn(name = "reader_id")
  private Reader reader;

  /**
   * Дата выдачи
   */
  private final LocalDateTime issued_at;
  /**
   * Дата возврата
   */
  private LocalDateTime returned_at;

  public Issue(){
    issued_at = LocalDateTime.now();
  }

  public Issue(Book book, Reader reader) {
    this.book = book;
    this.reader = reader;
    this.issued_at = LocalDateTime.now();
  }

}
