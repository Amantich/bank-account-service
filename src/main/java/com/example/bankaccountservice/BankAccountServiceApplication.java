package com.example.bankaccountservice;

import com.example.bankaccountservice.enums.AccountType;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository repository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                BankAccount account = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT :
                                AccountType.SAVINGS_ACCOUNT)
                        .balance(10000+Math.random()*10000)
                        .createdAt(LocalDate.now())
                        .currency("MAD")
                        .build();
                repository.save(account);
            }
        };
    }

}
