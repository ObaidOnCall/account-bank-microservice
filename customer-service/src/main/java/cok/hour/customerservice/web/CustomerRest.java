package cok.hour.customerservice.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cok.hour.customerservice.entities.Customer;
import cok.hour.customerservice.repositories.CustomerRepo;
import lombok.AllArgsConstructor;

@RestController
/**
 * @RequestMapping("/api")
 *
 * **/

// AllArgsConstructor will generate a Constructor with All  args so the spring container can inject the depedncy auto
@AllArgsConstructor 
public class CustomerRest {
    
    private CustomerRepo customerRepo ;


    @GetMapping("")
    public Map<String , Object> index(){
        Map<String , Object> indexData = new HashMap<>() ;
        indexData.put("message" , "Customer Service") ;
        
        return indexData ;
    }

    // @GetMapping("/customers")
    // public List<Customer> allCustomers(){
        
    //     return customerRepo.findAll() ;
    // }

    @GetMapping("/customers")
    public Map<String , Object> allCustomers(){
        
        Map<String,Object> map = new HashMap<>();
        List<Customer> customers = customerRepo.findAll() ;
        map.put("customers", customers) ;
        map.put("info", "this enpoint content all customers data") ;
        map.put("status" , 41) ;
        return map ;
    }


    @GetMapping("/customers/{id}")
    public Optional<Customer> findCustomer(@PathVariable Long id){
        
        return customerRepo.findById(id) ;
    }

}
