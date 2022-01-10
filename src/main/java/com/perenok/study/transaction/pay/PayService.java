package com.perenok.study.transaction.pay;

import com.perenok.study.transaction.account.Account;
import com.perenok.study.transaction.account.AccountResponse;
import com.perenok.study.transaction.account.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayService {

    private final AccountService accountService;
    private final PayRepository payRepository;

    @Transactional
    public PayResponse create(PayRequest request) {
        log.info("currentTransactionName : {}", TransactionSynchronizationManager.getCurrentTransactionName());

        return PayResponse.create(payRepository.save(request.toEntity()));
    }

    @Transactional(readOnly = true)
    public PayResponse show(Long id) {
        log.info("currentTransactionName : {}", TransactionSynchronizationManager.getCurrentTransactionName());

        return PayResponse.create(payRepository.findById(id).orElseThrow());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transfer(TransferRequest request) {
        log.info("currentTransactionName : {}", TransactionSynchronizationManager.getCurrentTransactionName());

        Long senderId = request.getSenderId();
        Long receiverId = request.getReceiverId();
        Long amount = request.getAmount();

        send(senderId, amount);
        receive(receiverId, amount);
    }

    private void send(Long senderId, Long amount) {
        log.info("Sender ID: {}", senderId.toString());

        AccountResponse accountResponse = accountService.show(senderId);
        Account senderAccount = accountResponse.toEntity();
        senderAccount.sendMoney(amount);
    }

    private void receive(Long receiverId, Long amount) {
        log.info("Receiver ID: {}", receiverId.toString());

        AccountResponse accountResponse = accountService.show(receiverId);
        Account receiverAccount = accountResponse.toEntity();
        receiverAccount.receiveMoney(amount);
    }
}
