package net.adil.customerservice;

import net.adil.customerservice.entities.Customer;
import net.adil.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
	return args->{
		List<Customer> customers=List.of(
				Customer.builder().
						firstName("adil").
						lastName("qarboua").
						email("mcadilqarboua@gmail.com").
						build(),
				Customer.builder().
						firstName("ahmed").
						lastName("qarboua").
						email("ahmed.qarboua@gmail.com").
						build(),
				Customer.builder().
						firstName("anas").
						lastName("qarboua").
						email("mqarboua@gmail.com").
						build()
		);
		customerRepository.saveAll(customers);

	};

	}
}
