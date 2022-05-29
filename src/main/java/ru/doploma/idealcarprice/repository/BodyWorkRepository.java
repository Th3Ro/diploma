package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.BodyWork;

import java.util.Optional;

public interface BodyWorkRepository extends CrudRepository<BodyWork, Long> {
    Optional<BodyWork> findById(Long id);

    Optional<BodyWork> findByName(String name);
}
