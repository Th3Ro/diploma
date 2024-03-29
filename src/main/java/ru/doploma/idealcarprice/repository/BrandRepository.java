package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.Brand;

import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Long> {
    Brand findByName(String name);

    List<Brand> findAll();
}
