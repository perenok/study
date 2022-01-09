package com.perenok.study.transaction.account;

import com.perenok.study.transaction.pay.TransferRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponse> create(@RequestBody AccountRequest request) {
        AccountResponse accountResponse = accountService.create(request);
        return ResponseEntity.status(201).body(accountResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> show(@PathVariable Long id) {
        AccountResponse accountResponse = accountService.show(id);
        return ResponseEntity.ok(accountResponse);
    }
}
