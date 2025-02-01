package com.ilm.creditscoringservice.service;

import com.ilm.creditscoringservice.event.LoanApplicationEvent;
import com.ilm.creditscoringservice.external.ExternalCreditScoreService;
import com.ilm.creditscoringservice.model.CreditScoreRecord;
import com.ilm.creditscoringservice.repository.CreditScoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CreditScoringService {
    private final CreditScoreRepository repository;
    private final ExternalCreditScoreService externalService;

    public CreditScoringService(CreditScoreRepository repository, ExternalCreditScoreService externalService) {
        this.repository = repository;
        this.externalService = externalService;
    }

  //  @KafkaListener(topics = "loan-applications", groupId = "credit-scoring-group")
    public int processLoanApplication(@RequestBody LoanApplicationEvent loan) {
        int cibilScore = externalService.fetchCibilScore(loan.getId());
        int equifaxScore = externalService.fetchEquifaxScore(loan.getId());
        int experianScore = externalService.fetchExperianScore(loan.getId());

        int historyFactor = loan.getPersonCreditHistoryLength() * 5;
        int consolidatedScore = ((cibilScore + equifaxScore + experianScore) / 3) + historyFactor;
        consolidatedScore = Math.min(consolidatedScore, 850);

        CreditScoreRecord record = new CreditScoreRecord();
        record.setApplicantId(loan.getId());
        record.setCibilScore(cibilScore);
        record.setEquifaxScore(equifaxScore);
        record.setExperianScore(experianScore);
        record.setConsolidatedCreditScore(consolidatedScore);

        repository.save(record);
        return consolidatedScore;
    }
}
