package com.notebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notebook")
public class NotebookController {


    @GetMapping("/all")
    public String getAllNotebooks(){
        return "Hello Notebook";
    }
}
