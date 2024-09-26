package ru.reks.ex1sem5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.reks.ex1sem5.repository.AccountRepository;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;
}
