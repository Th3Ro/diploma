package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.Model;
import ru.doploma.idealcarprice.model.PartCode;

import java.util.List;
import java.util.Optional;

public interface PartCodeRepository extends CrudRepository<PartCode, Long> {
    Optional<PartCode> findByDetail_Id(Long id);

    List<PartCode> findAllByModel_id(Long id);

    List<PartCode> findAll();

    List<PartCode> findAllByModel(Model model);
}
