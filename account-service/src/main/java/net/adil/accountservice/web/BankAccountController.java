package net.adil.accountservice.web;

import net.adil.accountservice.entities.BankAccount;
import net.adil.accountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {
private BankAccountRepository bankAccountRepository;
public BankAccountController(BankAccountRepository bankAccountRepository){
    this.bankAccountRepository=bankAccountRepository;
}

@GetMapping("/accounts")
public List<BankAccount> bankAccountList(){
    return bankAccountRepository.findAll();
}
@GetMapping("/accounts/{id}")
public BankAccount bankAccountById(@PathVariable String id)
{
    return bankAccountRepository.findById(id).get();

}
}
