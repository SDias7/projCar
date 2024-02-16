package org.upskill.ProjectJavaC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.upskill.ProjectJavaC.Services.ModelService;
import org.upskill.ProjectJavaC.models.Model;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelService modelService;


    @PostMapping
    public Model criarMarca(@RequestBody Model model) {
        return modelService.salvarModel(model);
    }

}
