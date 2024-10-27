package com.example.bankaccountservice.web;

import com.example.bankaccountservice.Dtos.BankAccountRequestDto;
import com.example.bankaccountservice.Dtos.BankAccountResponseDto;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import com.example.bankaccountservice.services.BankAccountServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author tensa
 **/
@Controller
@AllArgsConstructor
public class BankAccountGraphQlController {

    private BankAccountRepository bankAccountRepository;
    private BankAccountServiceImp bankAccountServiceImp;


    @QueryMapping
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("account not found"));
    }

    @MutationMapping
    public BankAccountResponseDto addAccount(@Argument BankAccountRequestDto bankAccount) {
        return bankAccountServiceImp.createBankAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDto updateBankAccount(@Argument String id, @Argument BankAccountRequestDto bankAccount) {
        return this.bankAccountServiceImp.updateBankAccount(id,bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id) {
        this.bankAccountRepository.deleteById(id);
    }

}
