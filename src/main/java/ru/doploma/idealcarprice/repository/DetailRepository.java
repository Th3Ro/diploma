package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.Detail;

import java.util.Optional;

public interface DetailRepository extends CrudRepository<Detail, Long> {
    Optional<Detail> findById(Long id);
}
