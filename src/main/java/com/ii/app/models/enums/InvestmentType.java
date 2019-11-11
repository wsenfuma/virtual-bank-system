package com.ii.app.models.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "investment_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "investment_status")
    private InvestmentStatus investmentStatus;

    @Column(name = "daily_profit")
    private BigDecimal dailyProfit;

    @Column(name="minimal_balance")
    private BigDecimal minimalBalance;

    @Column(name="maximal_balance")
    private BigDecimal maximalBalance;

    public enum InvestmentStatus {
        ACTIVE,
        CLOSED
    }
}

