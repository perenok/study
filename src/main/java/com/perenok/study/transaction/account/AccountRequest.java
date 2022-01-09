package com.perenok.study.transaction.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    private Long amount;

    public Account toEntity() {
        return Account.create(amount);
    }
}
