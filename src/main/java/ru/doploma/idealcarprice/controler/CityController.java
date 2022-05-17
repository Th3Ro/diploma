package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.helper.SelectedItemsByUserHelper;
import ru.doploma.idealcarprice.model.City;;
import ru.doploma.idealcarprice.service.CityService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityService.findAll();
    }

    @PostMapping("/city")
    public void setCity(@RequestBody String cityId) {
        City city = cityService.findById(Long.parseLong(cityId));
        SelectedItemsByUserHelper.setSelectedCity(city);
    }
}
