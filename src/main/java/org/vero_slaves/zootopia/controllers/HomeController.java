package org.vero_slaves.zootopia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping(path = "/")
    public String index() {
        
        return "Hello. This is zootopia database. Enjoy!";
        
    }
    
}