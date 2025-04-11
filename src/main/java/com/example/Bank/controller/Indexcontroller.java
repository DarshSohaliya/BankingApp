package com.example.Bank.controller;

import com.example.Bank.model.IndexModel;
import com.example.Bank.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/index")
public class Indexcontroller {

    @Autowired
    IndexService indexService;

    @PostMapping("/set")
    public String Set(IndexModel data){
        System.out.println("Data ::: " + data);
        indexService.SetData(data);
        return "OKK";
    }
}
