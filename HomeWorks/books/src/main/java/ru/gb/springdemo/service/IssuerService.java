package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.DTO.IssueDTO;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.demo.MyBean;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.IssueRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssuerService {

  // спринг это все заинжектит
  private final BookService bookService;
  private final ReaderService readerService;
  private final IssueRepository issueRepository;
  private final MyBean myBean;

  public Issue issue(IssueRequest request) {
    if (bookService.findBookById(request.getBookId()) == null) {
      throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
    }
    if (readerService.getReaderById(request.getReaderId()) == null) {
      throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
    }
    // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)

    Reader reader = readerService.getReaderById(request.getReaderId());

    if (readerCanTakeBook(reader)){
      Issue issue = new Issue(bookService.findBookById(request.getBookId()), reader);
      issueRepository.save(issue);
      return issue;
    }

    return null;
  }

  private boolean readerCanTakeBook(Reader reader){
    List<Issue> openedIssuesByReader = issueRepository.findByReader(reader).stream().filter(i -> i.getReturned_at() == null).toList();

    return openedIssuesByReader.size() < myBean.getMaxAlowedBooks();
  }

  public Issue getIssue(long id){
    return issueRepository.getById(id);
  }

  public List<Issue> allReaderIssues(Reader reader){
    return issueRepository.findByReader(reader);
  }

  public Issue closeIssue(long id){
    Issue issue = issueRepository.getById(id);

    if (issue != null){
      if (issue.getReturned_at() == null){
        issue.setReturned_at(LocalDateTime.now());
      }
    }

    return issue;
  }

  public List<IssueDTO> allIssuesDTO(){
    List<Issue> issues =  issueRepository.findAll();

    List<IssueDTO> issuesDTO = new ArrayList<>();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    for (Issue issue: issues) {
      issuesDTO.add(new IssueDTO(bookService.findBookById(issue.getId()).getName(),
              readerService.getReaderById(issue.getReader().getId()).getName(),
              dtf.format(issue.getIssued_at()),
              issue.getReturned_at() == null ? "": dtf.format(issue.getReturned_at())));
    }

    return issuesDTO;
  }
}
