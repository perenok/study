package com.perenok.study.transaction.account;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountResponse {

    private Long id;
    private Long amount;

    public static AccountResponse create(Account account) {
        return new AccountResponse(account.getId(), account.getAmount());
    }

    public Account toEntity() {
        return Account.create(id, amount);
    }
}
