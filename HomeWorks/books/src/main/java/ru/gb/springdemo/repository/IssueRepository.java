package ru.gb.springdemo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.Issue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {

  private final List<Issue> issues;

  public IssueRepository() {
      this.issues = new ArrayList<>();
  }

  public void save(Issue issue) {
    // insert into ....
      issues.add(issue);
  }

  @PostConstruct
  private void generate(){
      save(new Issue(1,1));
      save(new Issue(2,2));
  }

  public Issue getById(long id) {
      return issues.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
  }

  public List<Issue>  filterByReader(long readerId){
      return issues.stream().filter(i -> i.getReaderId() == readerId).toList();
  }

  public List<Issue> getAllIssues(){
      return List.copyOf(issues);
  }
}
