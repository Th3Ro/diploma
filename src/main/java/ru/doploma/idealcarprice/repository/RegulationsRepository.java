package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.Regulations;

import java.util.List;

public interface RegulationsRepository extends CrudRepository<Regulations, Long> {
    List<Regulations> findAll();
}
