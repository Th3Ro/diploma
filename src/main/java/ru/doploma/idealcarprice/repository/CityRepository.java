package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {
    Optional<City> findById(Long id);

    List<City> findAll();
}
