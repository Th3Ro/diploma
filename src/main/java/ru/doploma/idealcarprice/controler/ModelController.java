package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.doploma.idealcarprice.model.Brand;
import ru.doploma.idealcarprice.model.Model;
import ru.doploma.idealcarprice.service.BrandService;
import ru.doploma.idealcarprice.service.ModelService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ModelController {
    private final ModelService modelService;
    private final BrandService brandService;

    @PostMapping("/models")
    public List<Model> getModels(@RequestBody String brandName) {
        Brand brand = brandService.findByName(brandName);
        List<Model> models = modelService.findAllByBrand(brand);
        return models;
    }

    @GetMapping("/brands")
    public List<Brand> getBrands() {
        return brandService.findAll();
    }
}
