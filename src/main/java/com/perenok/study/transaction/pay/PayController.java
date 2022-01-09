package com.perenok.study.transaction.pay;

import com.perenok.study.transaction.account.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pay")
public class PayController {

    private final PayService payService;

    @PostMapping
    public ResponseEntity<PayResponse> create(@RequestBody PayRequest request) {
        PayResponse payResponse = payService.create(request);
        return ResponseEntity.status(201).body(payResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayResponse> show(@PathVariable Long id) {
        PayResponse payResponse = payService.show(id);
        return ResponseEntity.ok(payResponse);
    }

    @PutMapping
    public ResponseEntity<AccountResponse> transfer(@RequestBody TransferRequest request) {
        payService.transfer(request);
        return ResponseEntity.noContent().build();
    }
}
