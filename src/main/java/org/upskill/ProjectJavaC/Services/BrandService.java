package org.upskill.ProjectJavaC.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.upskill.ProjectJavaC.models.Brand;
import org.upskill.ProjectJavaC.models.BrandRepository;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand salvarMarca(Brand brand) {
        return brandRepository.save(brand);
    }



}
