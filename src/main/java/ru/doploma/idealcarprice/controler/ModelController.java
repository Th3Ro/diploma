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

    public static Model selectedModel = null;

    @PostMapping("/models")
    public List<Model> getModels(@RequestBody String brandName) {
        Brand brand = brandService.findByName(brandName);
        return modelService.findAllByBrand(brand);
    }
}
