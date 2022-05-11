package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.Defect;

import java.util.List;

public interface DefectRepository extends CrudRepository<Defect, Long> {
    List<Defect> findAll();
}
