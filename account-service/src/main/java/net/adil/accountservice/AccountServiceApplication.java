package net.adil.accountservice;

import lombok.Builder;
import net.adil.accountservice.entities.BankAccount;
import net.adil.accountservice.enums.AccountType;
import net.adil.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
//important remember that for good practices you should add documentation
	// openApi Spring doc maven dep sl4j?

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
		return args -> {
			List<BankAccount> accounts=List.of(
					BankAccount.builder().
							accountId(UUID.randomUUID().toString()).
							createdAt(LocalDate.now()).
							currency("MAD").
							balance(10000d).
							type(AccountType.CURRENT_ACCOUNT).
							customerId(1L).
							build(),
					BankAccount.builder().
							accountId(UUID.randomUUID().toString()).
							createdAt(LocalDate.now()).
							currency("MAD").
							balance(20000d).
							type(AccountType.SAVINGS_ACCOUNT).
							customerId(2L).
							build()
			);
			bankAccountRepository.saveAll(accounts);
		};
	}
}
