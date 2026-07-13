package com.Flyrank.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class Controller{
    @Autowired
    private UnsettledRepository repository;

    @GetMapping("/listar")
    public List<Unsettled> listar(){
        List<Unsettled> unsettled = repository.findAll();
            System.out.println("WELCOME TO OUR WEB PAGE");
        return unsettled;

    }
    @GetMapping("/testing")
    public String testing(){
        System.out.println("A api funciona");
        return "This is my API, im so glad ur here";
    }


}