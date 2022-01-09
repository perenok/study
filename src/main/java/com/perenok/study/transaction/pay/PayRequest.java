package com.perenok.study.transaction.pay;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PayRequest {

    private Long senderId;
    private Long receiverId;
    private Long amount;

    public static PayRequest create(Long senderId, Long receiverId, Long amount) {
        return new PayRequest(senderId, receiverId, amount);
    }

    public Pay toEntity() {
        return Pay.create(senderId, receiverId, amount);
    }
}
