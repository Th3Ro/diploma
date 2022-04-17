package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.doploma.idealcarprice.model.Brand;
import ru.doploma.idealcarprice.service.BrandService;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {
    private final BrandService brandService;

    @GetMapping("/")
    public String index(Model model) {
        List<Brand> brands = brandService.findAll();
        model.addAttribute("brands", brands);
        return "index";
    }
}
