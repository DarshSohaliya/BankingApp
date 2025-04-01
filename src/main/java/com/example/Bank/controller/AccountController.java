package com.example.Bank.controller;

import com.example.Bank.model.Account;
import com.example.Bank.model.AccountUser;
import com.example.Bank.model.Transaction;
import com.example.Bank.model.TransactionDTO;
import com.example.Bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/open-ac")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/open")
    public void CreateAc(@RequestBody Account account){
        accountService.createAc(account);
    }

    @PostMapping("/withdrow")

    public String WithDrow(@RequestBody AccountUser accountUser){

       try {
           boolean isSuccess=  accountService.WithDrow(accountUser.getAcNo(),accountUser.getAmount());

           if(isSuccess){
               return "WithDrow SuccessFully";
           }
           else{
               return "Inficient funds!";
           }
       }
       catch (Exception e){
          return "Error"  + e.getMessage();
       }

    }


    @PostMapping("/deposite")

    public String Deposite(@RequestBody AccountUser accountUser){
       try{

           boolean isDeposite = accountService.Deposite(accountUser.getAcNo(),accountUser.getAmount());

           if(isDeposite){
               return "Deposite Successfully";
           }
           else{
               return "Account not found";
           }
       }
       catch (Exception e){
           return "Error" +  e.getMessage();
       }
    }

    @PostMapping("/transaction")
    public String Transfer(@RequestBody TransactionDTO transactionDTO){
       try{
           boolean isTransaction = accountService.Transfer(transactionDTO.getSenderAcNo(),transactionDTO.getRecieverAcNo(),transactionDTO.getAmount());

           if(isTransaction){
               return "Transaction SuccessFully!";
           }
           else{
               return "Something went wrong";
           }
       }
       catch (Exception e){
            return "Error Transaction" + e.getMessage();
       }
    }

    @PostMapping("/acdetail")

    public Account AcDetail(@RequestHeader long acNo){
        return accountService.AccountDetail(acNo);
    }

    @GetMapping("/statement")

    public List<Transaction> GetStatement(@RequestHeader long acNo){

        List<Transaction> transactions =  accountService.getAccountStatement(acNo);
        return transactions;
    }
}
