package com.perenok.study.transaction.account;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "create")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long amount;

    private Account(Long amount) {
        this.amount = amount;
    }

    public static Account create(Long price) {
        return new Account(price);
    }

    public void sendMoney(Long amount) {
        this.amount -= amount;
    }

    public void receiveMoney(Long amount) {
        this.amount += amount;
    }
}
