package ru.komarreks.students.services;

import org.springframework.stereotype.Component;
import ru.komarreks.students.model.Student;
import ru.komarreks.students.repository.RepositoryInterface;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepositoryImpl implements RepositoryInterface {

    private List<Student> base = new ArrayList<>();
    private static int counter = 1;

    public RepositoryImpl() {
        create("Иван Иванов", "JAVA");
        create("Петр Петров", "JAVA");
        create("Сидор Сидоров", "JAVA");
        create("Иван Петров", "PYTHON");
        create("Иван Сидоров", "PYTHON");
        create("Петр Иванов", "WEB-DEVELOPING");
        create("Петр Сидоров", "SQL");
        create("Сидор Иванов", "DESIGN");
        create("Сидор Петров", "PHP");

        counter = base.stream().max((s1,s2) -> Integer.compare(s1.getId(), s2.getId())).get().getId() + 1;
    }

    public boolean create(String name, String group){
        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setGroup(group);

        return create(newStudent);
    }

    private boolean addToBase(Student student){
        base.add(student);
        return true;
    }

    @Override
    public boolean create(Student student) {
        if (student.getId() == 0){
            student.setId(counter++);
        }

        return addToBase(student);
    }

    @Override
    public Student read(int id) {
        return base.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean update(Student student) {
        Student studentOnDB = base.stream().filter(s -> student.getId() == student.getId()).findFirst().orElse(null);

        if (studentOnDB != null){
            studentOnDB.setName(student.getName());
            studentOnDB.setGroup(student.getGroup());
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return base.removeIf(student -> student.getId() == id);
    }

    @Override
    public List<Student> getAll() {
        return base;
    }

    @Override
    public List<Student> findByName(String name) {
        return base.stream().filter(student -> student.getName().toLowerCase().indexOf(name.toLowerCase())>-1).toList();
    }

    @Override
    public List<Student> fyndByGroup(String group){
        return base.stream().filter(student -> student.getGroup().toLowerCase().indexOf(group.toLowerCase())>-1).toList();
    }
}
