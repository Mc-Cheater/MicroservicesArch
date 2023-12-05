package net.adil.accountservice.web;

import net.adil.accountservice.clients.CustomerRestClient;
import net.adil.accountservice.entities.BankAccount;
import net.adil.accountservice.model.Customer;
import net.adil.accountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {
private BankAccountRepository bankAccountRepository;
private CustomerRestClient customerRestClient;
public BankAccountController(BankAccountRepository bankAccountRepository,CustomerRestClient customerRestClient){
    this.bankAccountRepository=bankAccountRepository;
    this.customerRestClient=customerRestClient;
}

@GetMapping("/accounts")
public List<BankAccount> bankAccountList(){
    return bankAccountRepository.findAll();
}
@GetMapping("/accounts/{id}")
public BankAccount bankAccountById(@PathVariable String id)
{
    BankAccount bankAccount=bankAccountRepository.findById(id).get();
    Customer customer= customerRestClient.findCustomerById(bankAccount.getCustomerId());
    bankAccount.setCustomer(customer);
    return bankAccount;
}
}
