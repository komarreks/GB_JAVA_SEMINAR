package ru.komarreks.students.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Student {
    private int id;
    private String name;
    private String group;

    public Student() {
    }

    public Student(String name, String group) {
        this.name = name;
        this.group = group;
    }
}
