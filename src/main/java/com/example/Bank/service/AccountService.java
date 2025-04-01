package com.example.Bank.service;

import com.example.Bank.model.Account;
import com.example.Bank.model.Transaction;
import com.example.Bank.model.TransactionDTO;
import com.example.Bank.repository.AccountRepository;
import com.example.Bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public void createAc(Account account){
        System.out.println(account.getBalance() + account.getName());
          account.setBalance(account.getBalance());
         long acNo = generateAcNo();
        account.setAcNo(acNo);
        accountRepository.save(account);
    }

    public Long  generateAcNo(){
        long acNo;
         final Random random = new Random();
        do {
            acNo = 1_000_000_000L + (long)(random.nextDouble() * 9_000_000_000L);
        } while (accountRepository.findByAcNo(acNo) != null); // DB check for uniqueness

        return acNo;
    }

    public boolean WithDrow(long acNo,double amount){

       Account account =  accountRepository.findByAcNo(acNo);

       if(account == null){
           throw new RuntimeException("Account Not Found");
       }
       if(account.getBalance() < amount){
           throw  new RuntimeException("Inficient balance");
       }

       account.setBalance(account.getBalance() - amount);

       accountRepository.save(account);

       createStatement(acNo,"WithDrow",amount);


       return true;

    }

    public boolean Deposite(long acNo , double amount){
         Account account = accountRepository.findByAcNo(acNo);

         if(account == null){
             throw  new RuntimeException("Account is not found");
         }

         account.setBalance(account.getBalance() + amount);
         accountRepository.save(account);



         createStatement(acNo,"Deposite",amount);


         return true;
    }

    public boolean Transfer(long senderAcNo,long recieverAcNo,double amount){


        Account sender = accountRepository.findByAcNo(senderAcNo);
        Account reciever = accountRepository.findByAcNo(recieverAcNo);
     System.out.println(senderAcNo + "::::" +  recieverAcNo);
        if(sender == null || reciever == null){
            throw  new RuntimeException("Account not found");
        }

        sender.setBalance(sender.getBalance() - amount);
        reciever.setBalance(reciever.getBalance() + amount);
        accountRepository.save(sender);
        accountRepository.save(reciever);

       createStatement(senderAcNo,"Transfer",amount);
       createStatement(recieverAcNo,"Transfer",amount);

        return true;
    }

    public Account AccountDetail(long acNo){

            Account account = accountRepository.findByAcNo(acNo);

         return account;

    }
    public void  createStatement(long acNo,String type,double amount){
          Transaction transaction = new Transaction();

          transaction.setAcNo(acNo);
          transaction.setAmount(amount);
          transaction.setType(type);
          transaction.setDate(Date.valueOf(LocalDate.now()));

          transactionRepository.save(transaction);

    }

    public List<Transaction> getAccountStatement(long acNo){

         return  transactionRepository.findByAcNo(acNo);
    }
}
