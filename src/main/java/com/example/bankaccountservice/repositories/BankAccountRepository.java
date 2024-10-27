package com.example.bankaccountservice.repositories;

import com.example.bankaccountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tensa
 **/
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
