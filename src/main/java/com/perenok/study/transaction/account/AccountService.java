package com.perenok.study.transaction.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AccountResponse create(AccountRequest request) {
        log.info("currentTransactionName : {}", TransactionSynchronizationManager.getCurrentTransactionName());

        Account account = request.toEntity();
        return AccountResponse.create(accountRepository.save(account));
    }

    @Transactional(readOnly = true)
    public AccountResponse show(Long id) {
        log.info("currentTransactionName : {}", TransactionSynchronizationManager.getCurrentTransactionName());

        Account account = accountRepository.findById(id)
                .orElseThrow();
        return AccountResponse.create(account);
    }
}
