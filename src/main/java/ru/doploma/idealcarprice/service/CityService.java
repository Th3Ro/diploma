package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.model.City;
import ru.doploma.idealcarprice.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public City findById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        return city.orElse(null);
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }
}
