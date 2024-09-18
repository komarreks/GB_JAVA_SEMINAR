package ru.gb.springdemo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.PropertyValues;
import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {

  private final List<Reader> readers;

  public ReaderRepository() {
    this.readers = new ArrayList<>();
  }

  @PostConstruct
  public void generateData() {
    readers.addAll(List.of(
      new Reader("Игорь"),
      new Reader("Павел"),
      new Reader("Иван")
    ));
  }

  public Reader getReaderById(long id) {
    return readers.stream().filter(it -> Objects.equals(it.getId(), id))
      .findFirst()
      .orElse(null);
  }

  public boolean deleteBookById(long id) {
    return readers.removeIf(r -> r.getId() == id);
  }

  public List<Reader> getReaders() {
    return List.copyOf(readers);
  }

  public void addReader(Reader reader) {
    readers.add(reader);
  }
}
