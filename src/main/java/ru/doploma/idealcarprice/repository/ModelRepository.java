package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.Brand;
import ru.doploma.idealcarprice.model.Model;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends CrudRepository<Model, Long> {
    Optional<Model> findById (Long id);

    List<Model> findAllByBrand (Brand brand);
}
