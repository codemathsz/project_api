package br.com.codemathsz.stage.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/ping")
public class PingController {

    @GetMapping("")
    public String pong(){
        return "pong";
    }
}
