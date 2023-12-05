package net.adil.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.adil.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    public Customer findCustomerById(@PathVariable  Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name="customerService",fallbackMethod = "getDefaultCustomers")
    public List<Customer> customers();

   default public Customer getDefaultCustomer(Long id,Exception exception){
       Customer defaultCustomer=new Customer();

       defaultCustomer.setId(id);
       defaultCustomer.setFirstName("this is a default customer your service is down");
       defaultCustomer.setLastName("Default");
       defaultCustomer.setEmail("Default");


       return defaultCustomer;
   }

   default public List<Customer> getDefaultCustomers(Exception exception){
       return List.of();
   }
}
