package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.Model;
import ru.doploma.idealcarprice.model.PartCode;

import java.util.List;

public interface PartCodeRepository extends CrudRepository<PartCode, Long> {
    List<PartCode> findAll();

    List<PartCode> findAllByModel (Model model);
}
