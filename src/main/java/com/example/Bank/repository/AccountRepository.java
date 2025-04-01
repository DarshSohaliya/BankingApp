package com.example.Bank.repository;

import com.example.Bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account , Long > {

    Account findByAcNo(long acNo);
}
