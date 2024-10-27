package com.example.bankaccountservice.Dtos;

import com.example.bankaccountservice.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author tensa
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountResponseDto {
    private String id;
    private LocalDate createdAt;
    private Double balance;
    private String currency;
    private AccountType accountType;
}
