package com.perenok.study.transaction;

import com.perenok.study.transaction.account.AccountRequest;
import com.perenok.study.transaction.account.AccountResponse;
import com.perenok.study.transaction.account.AccountService;
import com.perenok.study.transaction.pay.PayService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;
    @Autowired
    private PayService payService;

    @Test
    @DisplayName("계좌이체 - 성공")
    void transferTest() {
        //given
        AccountResponse account1 = accountService.create(new AccountRequest(10000L));
        AccountResponse account2 = accountService.create(new AccountRequest(20000L));

        //when


        //then
        assertEquals(accountService.show(account1.getId()).getAmount(), 5000L);
        assertEquals(accountService.show(account2.getId()).getAmount(), 25000L);
    }
}
