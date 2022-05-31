package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.SupplierSite;

import java.util.Optional;

public interface SupplierSiteRepository extends CrudRepository<SupplierSite, Long> {
    Optional<SupplierSite> findById(Long id);
}
