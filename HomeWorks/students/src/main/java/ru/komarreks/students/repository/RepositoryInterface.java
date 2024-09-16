package ru.komarreks.students.repository;

import org.springframework.stereotype.Repository;
import ru.komarreks.students.model.Student;

import java.util.List;

@Repository
public interface RepositoryInterface {
    boolean create(Student student);
    Student read(int id);
    boolean update(Student student);
    boolean delete(int id);
    List<Student> getAll();
    List<Student> findByName(String name);
    List<Student> fyndByGroup(String group);
}
