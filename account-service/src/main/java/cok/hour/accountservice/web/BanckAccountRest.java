package cok.hour.accountservice.web;

import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cok.hour.accountservice.clients.CustemerRestClient;
import cok.hour.accountservice.entities.BanckAccount;
import cok.hour.accountservice.models.Customer;
import cok.hour.accountservice.repositories.BanckAccountRepo;

@RestController
public class BanckAccountRest {
    
    
    private final BanckAccountRepo banckAccountRepo;
    private final CustemerRestClient custemerRestClient ;


    public BanckAccountRest(BanckAccountRepo banckAccountRepo , CustemerRestClient custemerRestClient){
        this.banckAccountRepo = banckAccountRepo ;
        this.custemerRestClient = custemerRestClient ;
    }

    @GetMapping("")
    public Map<String , Object> index(){
        Map<String , Object> indexData = new HashMap<>() ;
        indexData.put("message" , "Customer Service") ;
        
        return indexData ;
    }


    @GetMapping("/bank-accounts")
    public List<BanckAccount> allBanckAccount() {

        List<BanckAccount> allBanckAccounts = banckAccountRepo.findAll() ;
        allBanckAccounts.forEach(acc -> {
            acc.setCustemer(custemerRestClient.findCustomerById(acc.getCustomer_id()));
        });
        
        return  allBanckAccounts;
    }


    @GetMapping("/bank-accounts/{id}")
    public BanckAccount findAccount(@PathVariable String id) {
        BanckAccount banckAccount = banckAccountRepo.
                                        findById(id).get();
        Customer customer = custemerRestClient.
                            findCustomerById(banckAccount.
                                                getCustomer_id());
        banckAccount.setCustemer(customer);
        return banckAccount ;
    }



}
