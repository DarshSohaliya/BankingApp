package com.example.Bank.repository;

import com.example.Bank.model.IndexModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexRepo extends JpaRepository<IndexModel,Long> {

}
