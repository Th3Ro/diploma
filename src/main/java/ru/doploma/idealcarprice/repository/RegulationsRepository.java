package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.Regulations;

import java.util.List;
import java.util.Optional;

public interface RegulationsRepository extends CrudRepository<Regulations, Long> {
    Optional<Regulations> findById(Long id);

    List<Regulations> findAll();
}
