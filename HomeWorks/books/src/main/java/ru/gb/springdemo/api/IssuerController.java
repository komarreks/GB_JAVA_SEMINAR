package ru.gb.springdemo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.service.IssuerService;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("api/issue")
public class IssuerController {

  @Autowired
  private IssuerService service;

  @PostMapping
  public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
    log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());

    final Issue issue;
    try {
      issue = service.issue(request);
    } catch (NoSuchElementException e) {
      return ResponseEntity.notFound().build();
    }

    if (issue != null){
      log.info("Запрос одобрен: issueId = {}", issue.getId());
      return ResponseEntity.status(HttpStatus.OK).body(issue);
    }

    log.info("Запрос не одобрен");
    return ResponseEntity.status(HttpStatus.CONFLICT).body(issue);

  }

  @GetMapping("/{id}")
  public ResponseEntity<Issue> getIssue(@PathVariable long id){
    Issue issue = service.getIssue(id);

    if (issue != null) return ResponseEntity.status(HttpStatus.OK).body(issue);

    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  @PostMapping("/{issueId}")
  public ResponseEntity<Issue> closeIssue(@PathVariable long issueId){
    Issue issue = service.closeIssue(issueId);

    if (issue != null) return ResponseEntity.status(HttpStatus.OK).body(issue);

    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
}
