package com.example.bankaccountservice.web;

import com.example.bankaccountservice.Dtos.BankAccountRequestDto;
import com.example.bankaccountservice.Dtos.BankAccountResponseDto;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.services.IBankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tensa
 **/
@RestController
@AllArgsConstructor
public class AccountRestController {

    private IBankAccountService bankAccountService;

    @GetMapping("/accounts")
    public List<BankAccountResponseDto> getBankAccounts() {
     return this.bankAccountService.getAllBankAccounts();
    }

    @GetMapping("/accounts/{accountId}")
    public BankAccountResponseDto getBankAccountById(@PathVariable String accountId) {
        return this.bankAccountService.getBankAccountById(accountId);
    }

    @PostMapping("/accounts")
    public BankAccountResponseDto createBankAccount(@RequestBody BankAccountRequestDto bankAccount) {
        return this.bankAccountService.createBankAccount(bankAccount);
    }

    @PutMapping("/accounts/{accountId}")
    public BankAccountResponseDto updateBankAccount(@PathVariable String accountId,@RequestBody BankAccountRequestDto bankAccount) {
        return this.bankAccountService.updateBankAccount(accountId,bankAccount);
    }

}
