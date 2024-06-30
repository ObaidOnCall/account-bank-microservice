package cok.hour.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cok.hour.accountservice.entities.BanckAccount;

/**
 * BanckAccountRepo
 */
public interface BanckAccountRepo extends JpaRepository<BanckAccount , String>{

    
}
