package com.ilm.creditscoringservice.external;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ExternalCreditScoreService {
    public int fetchCibilScore(Long applicantId) {
        return new Random().nextInt(300) + 550;
    }
    public int fetchEquifaxScore(Long applicantId) {
        return new Random().nextInt(300) + 550;
    }
    public int fetchExperianScore(Long applicantId) {
        return new Random().nextInt(300) + 550;
    }
}
