package ru.gb.springdemo.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.Issue;

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

    public Issue getById(long id) {
      return issues.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public List<Issue>  filterByReader(long readerId){
      return issues.stream().filter(i -> i.getReaderId() == readerId).toList();
    }
}
