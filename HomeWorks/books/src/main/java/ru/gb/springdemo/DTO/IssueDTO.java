package ru.gb.springdemo.DTO;

import lombok.Getter;

@Getter
public class IssueDTO {
    private String book;
    private String reader;
    private String issued_at;
    private String returned_at;

    public IssueDTO(String book, String reader, String issued_at, String returned_at) {
        this.book = book;
        this.reader = reader;
        this.issued_at = issued_at;
        this.returned_at = returned_at;
    }
}
