package com.ilm.creditscoringservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CREDIT_SCORE_RECORD")
public class CreditScoreRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long applicantId;
    private int cibilScore;
    private int equifaxScore;
    private int experianScore;
    private int consolidatedCreditScore;

    // Getters and Setters
}