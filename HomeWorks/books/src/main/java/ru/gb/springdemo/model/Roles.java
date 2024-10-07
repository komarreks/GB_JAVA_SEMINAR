package ru.gb.springdemo.model;

public enum Roles {
    ADMIN("Admin"),
    READER("Reader");

    private String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
