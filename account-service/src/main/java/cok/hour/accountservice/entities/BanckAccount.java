package cok.hour.accountservice.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import cok.hour.accountservice.enums.AccountEnum;
import cok.hour.accountservice.models.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data @Getter @Setter
public class BanckAccount {
    

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;
    private double balance ;

    @CreationTimestamp
    private LocalDate create_at ;
    @UpdateTimestamp
    private LocalDate update_at ;
    private String currency ;
    private Long customer_id ;

    @Enumerated(value = EnumType.STRING)
    // @Column(columnDefinition = "enum('CURRENT_ACCOUNT','SAVING_ACCOUNT') DEFAULT 'CURRENT_ACCOUNT'")
    private AccountEnum type ;

    // its not gona turn into jpa sql statments 
    @Transient
    private Customer custemer ;

    
}
