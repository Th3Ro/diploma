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

    // todo добавить переменню для хранения текущей модели авто и попробовать сделать ее в скоупе session

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
