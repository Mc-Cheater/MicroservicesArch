package net.adil.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.adil.accountservice.enums.AccountType;
import net.adil.accountservice.model.Customer;

import java.time.LocalDate;

@Getter @Setter @ToString @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private Double balance;
    private LocalDate createdAt;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;
@Transient
    private Customer customer;
    // we can't do Jpa Mapping here thus the transient annotation
    // Customer isn't a JPA entity of the current project
    // it is located on another micro Service
    // and in another database
    // we can't expect hibernate to do the mapping here
    private Long customerId;
    //But we can declare the Foreign key here with an attribute
    // representing the primary key of Customer
}
