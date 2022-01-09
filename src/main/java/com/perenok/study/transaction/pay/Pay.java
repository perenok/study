package com.perenok.study.transaction.pay;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "create")
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long senderId;

    @Column
    private Long receiverId;

    @Column
    private Long amount;

    private Pay(Long senderId, Long receiverId, Long amount) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
    }

    public static Pay create(Long senderId, Long receiverId, Long amount) {
        return new Pay(senderId, receiverId, amount);
    }
}
