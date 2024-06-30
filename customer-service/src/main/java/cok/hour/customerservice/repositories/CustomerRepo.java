package cok.hour.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cok.hour.customerservice.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer , Long>{
    
}