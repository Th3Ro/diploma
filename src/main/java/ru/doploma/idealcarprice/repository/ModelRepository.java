package ru.doploma.idealcarprice.repository;


import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.Brand;
import ru.doploma.idealcarprice.model.Model;

import java.util.List;

public interface ModelRepository extends CrudRepository<Model, Long> {
    List<Model> findAllByBrand (Brand brand);
}
