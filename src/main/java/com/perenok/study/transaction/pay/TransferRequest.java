package com.perenok.study.transaction.pay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {

    private Long senderId;
    private Long receiverId;
    private Long amount;
}
