package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.model.City;
import ru.doploma.idealcarprice.repository.CityRepository;

import java.util.List;

@RestController
@AllArgsConstructor
public class CityController {
    private final CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityRepository.findAll();
    }
}
