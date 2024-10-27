package com.example.bankaccountservice.services;

import com.example.bankaccountservice.Dtos.BankAccountRequestDto;
import com.example.bankaccountservice.Dtos.BankAccountResponseDto;
import com.example.bankaccountservice.entities.BankAccount;

import java.util.List;

/**
 * @author tensa
 **/
public interface IBankAccountService {

    List<BankAccountResponseDto> getAllBankAccounts();

    BankAccountResponseDto getBankAccountById(String id);

    BankAccountResponseDto createBankAccount(BankAccountRequestDto bankAccount);

    BankAccountResponseDto updateBankAccount(String accountId, BankAccountRequestDto bankAccount);
}
