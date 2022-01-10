package com.perenok.study.transaction;

import com.perenok.study.transaction.account.AccountRequest;
import com.perenok.study.transaction.account.AccountResponse;
import com.perenok.study.transaction.account.AccountService;
import com.perenok.study.transaction.pay.PayService;
import com.perenok.study.transaction.pay.TransferRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PayServiceTest {

    @Autowired
    private AccountService accountService;
    @Autowired
    private PayService payService;

    private AccountResponse sender;
    private AccountResponse receiver;

    @BeforeEach
    void setup() {
        sender = accountService.create(new AccountRequest(10000L));
        receiver = accountService.create(new AccountRequest(20000L));
    }

    @Test
    @DisplayName("계좌이체 - 성공")
    void transferTest() {
        //given
        TransferRequest request = new TransferRequest(sender.getId(), receiver.getId(), 5000L);

        //when
        payService.transfer(request);

        //then
        assertEquals(accountService.show(sender.getId()).getAmount(), 5000L);
        assertEquals(accountService.show(receiver.getId()).getAmount(), 25000L);
    }
}
