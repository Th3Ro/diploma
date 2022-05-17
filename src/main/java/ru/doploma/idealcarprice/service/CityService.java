package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.model.City;
import ru.doploma.idealcarprice.repository.CityRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> findAll(){
        return cityRepository.findAll();
    }
}
