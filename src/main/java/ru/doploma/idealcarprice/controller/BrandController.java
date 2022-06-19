package ru.doploma.idealcarprice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.model.Brand;
import ru.doploma.idealcarprice.service.BrandService;

import java.util.List;

@RestController
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping("/brands")
    public List<Brand> getBrands() {
        return brandService.findAll();
    }
}
