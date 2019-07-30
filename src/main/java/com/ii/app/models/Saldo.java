package com.ii.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table (name = "saldos")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Saldo
{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Column (name = "balance")
        private BigDecimal balance;

        @ManyToOne (fetch = FetchType.EAGER)
        @JoinColumn (name = "currency_type_id", nullable = false)
        @JsonIgnore
        private CurrencyType currencyType;

        @ManyToOne
        @JoinColumn (name = "bank_account_id")
        private BankAccount bankAccount;
}