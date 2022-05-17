package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.City;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAll();
}
