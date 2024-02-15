package org.upskill.ProjectJavaC.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.upskill.ProjectJavaC.models.Veiculo;


@RestController
public class Rest {

    private Veiculo veiculoRequest;

    @GetMapping("/hello")
    public String exe() {
        return "Olá Cavalo";
    }
}