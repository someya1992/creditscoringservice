package com.ilm.creditscoringservice.controller;

import com.ilm.creditscoringservice.event.LoanApplicationEvent;
import com.ilm.creditscoringservice.service.CreditScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-score")
public class CreditScoringController {

    @Autowired
    private CreditScoringService creditScoringService;

    @PostMapping
    public ResponseEntity<Integer> calculateCreditScore(@RequestBody LoanApplicationEvent loan) {
        return ResponseEntity.ok(creditScoringService.processLoanApplication(loan));
    }
}
