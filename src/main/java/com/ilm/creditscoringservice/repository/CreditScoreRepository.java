package com.ilm.creditscoringservice.repository;

import com.ilm.creditscoringservice.model.CreditScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditScoreRepository extends JpaRepository<CreditScoreRecord, Long> {
}