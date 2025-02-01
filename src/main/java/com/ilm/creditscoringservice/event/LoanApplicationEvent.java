package com.ilm.creditscoringservice.event;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class LoanApplicationEvent {

    private Long id;
    private int age;
    private BigDecimal income;
    private String homeOwnership;
    private int employmentLength;
    private String loanIntent;
    private String loanGrade;
    private BigDecimal loanAmount;
    private BigDecimal loanInterestRate;
    private BigDecimal loanPercentIncome;
    private boolean personDefaultInFile;
    private int personCreditHistoryLength;

    // Getters and Setters
}
