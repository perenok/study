package com.perenok.study.transaction.pay;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class PayResponse {

    private Long id;
    private Long senderId;
    private Long receiverId;
    private Long amount;

    public static PayResponse create(Pay pay) {
        return new PayResponse(pay.getId(), pay.getSenderId(), pay.getReceiverId(), pay.getAmount());
    }
}
