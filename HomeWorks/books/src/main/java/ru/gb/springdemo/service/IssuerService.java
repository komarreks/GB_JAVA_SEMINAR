package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.DTO.IssueDTO;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.demo.MyBean;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.repository.BookRepository;
import ru.gb.springdemo.repository.IssueRepository;
import ru.gb.springdemo.repository.ReaderRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssuerService {

  // спринг это все заинжектит
  private final BookRepository bookRepository;
  private final ReaderRepository readerRepository;
  private final IssueRepository issueRepository;
  private final MyBean myBean;

  public Issue issue(IssueRequest request) {
    if (bookRepository.getBookById(request.getBookId()) == null) {
      throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
    }
    if (readerRepository.getReaderById(request.getReaderId()) == null) {
      throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
    }
    // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)

    if (readerCanTakeBook(request.getReaderId())){
      Issue issue = new Issue(request.getBookId(), request.getReaderId());
      issueRepository.save(issue);
      return issue;
    }

    return null;
  }

  private boolean readerCanTakeBook(long readerId){
    List<Issue> openedIssuesByReader = issueRepository.filterByReader(readerId).stream().filter(i -> i.getReturned_at() == null).toList();

    return openedIssuesByReader.size() < myBean.getMaxAlowedBooks();
  }

  public Issue getIssue(long id){
    return issueRepository.getById(id);
  }

  public List<Issue> allReaderIssues(long readerId){
    return issueRepository.filterByReader(readerId);
  }

  public Issue closeIssue(long issueId){
    Issue issue = issueRepository.getById(issueId);

    if (issue != null){
      if (issue.getReturned_at() == null){
        issue.setReturned_at(LocalDateTime.now());
      }
    }

    return issue;
  }

  public List<IssueDTO> allIssuesDTO(){
    List<Issue> issues =  issueRepository.getAllIssues();

    List<IssueDTO> issuesDTO = new ArrayList<>();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    for (Issue issue: issues) {
      issuesDTO.add(new IssueDTO(bookRepository.getBookById(issue.getId()).getName(),
              readerRepository.getReaderById(issue.getReaderId()).getName(),
              dtf.format(issue.getIssued_at()),
              issue.getReturned_at() == null ? "": dtf.format(issue.getReturned_at())));
    }

    return issuesDTO;
  }
}
