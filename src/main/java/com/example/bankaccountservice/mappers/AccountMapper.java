package com.example.bankaccountservice.mappers;

import com.example.bankaccountservice.Dtos.BankAccountRequestDto;
import com.example.bankaccountservice.Dtos.BankAccountResponseDto;
import com.example.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author tensa
 **/
@Service
public class AccountMapper {

public BankAccount toBankAccount(BankAccountRequestDto bankAccountRequestDto) {
    BankAccount bankAccount = new BankAccount();
    BeanUtils.copyProperties(bankAccountRequestDto, bankAccount);
    return bankAccount;
}

public BankAccountResponseDto toBankAccountResponseDto(BankAccount bankAccount) {
    BankAccountResponseDto bankAccountResponseDto = new BankAccountResponseDto();
    BeanUtils.copyProperties(bankAccount, bankAccountResponseDto);
    return bankAccountResponseDto;
}


}
