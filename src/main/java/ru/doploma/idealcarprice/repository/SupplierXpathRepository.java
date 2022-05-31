package ru.doploma.idealcarprice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.doploma.idealcarprice.model.SupplierXpath;

import java.util.Optional;

public interface SupplierXpathRepository extends CrudRepository<SupplierXpath, Long> {
    Optional<SupplierXpath> findBySupplierSiteId(Long supplierSiteId);
}
