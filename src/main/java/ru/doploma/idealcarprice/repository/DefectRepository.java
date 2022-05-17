package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.Defect;

import java.util.List;
import java.util.Optional;

public interface DefectRepository extends CrudRepository<Defect, Long> {
    Optional<Defect> findByName(String value);

    List<Defect> findAll();
}
