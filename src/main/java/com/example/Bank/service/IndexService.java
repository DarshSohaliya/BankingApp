package com.example.Bank.service;

import com.example.Bank.model.IndexModel;
import com.example.Bank.repository.IndexRepo;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    IndexRepo indexRepo;


    public void SetData(IndexModel data) {
         for(int i=0;i<100000;i++){
             indexRepo.save(data);
         }
    }
}
