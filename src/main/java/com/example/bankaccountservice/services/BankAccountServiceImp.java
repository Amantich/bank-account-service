package com.example.bankaccountservice.services;

import com.example.bankaccountservice.Dtos.BankAccountRequestDto;
import com.example.bankaccountservice.Dtos.BankAccountResponseDto;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.mappers.AccountMapper;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author tensa
 **/
@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImp implements IBankAccountService {
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;



    @Override
    public List<BankAccountResponseDto> getAllBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();

     return bankAccounts.stream().map(account->accountMapper.toBankAccountResponseDto(account)).toList();

    }
    @Override
    public BankAccountResponseDto getBankAccountById(String id) {
        BankAccount bankAccount=bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("bank account not found"));
        return accountMapper.toBankAccountResponseDto(bankAccount);
    }

    @Override
    public BankAccountResponseDto createBankAccount(BankAccountRequestDto bankAccount) {
        BankAccount account =   account= accountMapper.toBankAccount(bankAccount);
              account.setId(UUID.randomUUID().toString());
              account.setCreatedAt(LocalDate.now());
        BankAccount savedBankAccount=  bankAccountRepository.save(account);
       return accountMapper.toBankAccountResponseDto(savedBankAccount);

    }

    @Override
    public BankAccountResponseDto updateBankAccount(String accountId, BankAccountRequestDto bankAccount) {
         BankAccount account=  this.bankAccountRepository.findById(accountId).orElseThrow(()->new RuntimeException("bank account not found"));
         if (account.getAccountType() !=null) account.setAccountType(bankAccount.getAccountType());
         if (account.getBalance() !=null) account.setBalance(bankAccount.getBalance());
         if (account.getCurrency() !=null) account.setCurrency(bankAccount.getCurrency());
         bankAccountRepository.save(account);

         return accountMapper.toBankAccountResponseDto(account);
    }


}
