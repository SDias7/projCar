package org.upskill.ProjectJavaC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.upskill.ProjectJavaC.Services.BrandService;
import org.upskill.ProjectJavaC.models.Brand;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public Brand criarMarca(@RequestBody Brand brand) {
        return brandService.salvarMarca(brand);
    }

}
