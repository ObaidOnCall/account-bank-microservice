package cok.hour.accountservice.clients;

import cok.hour.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustemerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerServiceBreaker" , fallbackMethod = "getCustomer")
    Customer findCustomerById(@PathVariable Long id) ;

    @CircuitBreaker(name = "customerServiceBreaker" , fallbackMethod = "allCustomers")
    @GetMapping("/customers")
    List<Customer> findAllCustomers();



    default Customer getCustomer(Long id , Exception exception) {

        Customer customer = Customer.builder()
                            .id(1222)
                            .email("not avilabel")
                            .firstName("not avilable")
                            .lastName("not avilable")
                            .build();

        return customer ;

    }

    default Map<String, Object> allCustomers (Exception exception) {
        Map<String, Object> map = new HashMap<>() ;
        map.put("DefaultCustomer" , Customer.builder()
                .id(1222)
                .email("not avilabel")
                .firstName("not avilable")
                .lastName("not avilable")
                .build()) ;
        map.put("errorMessage" , exception.getMessage()) ;
        return map ;
    }
}
