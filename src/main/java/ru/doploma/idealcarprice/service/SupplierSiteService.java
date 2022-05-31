package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.model.SupplierSite;
import ru.doploma.idealcarprice.repository.SupplierSiteRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierSiteService {
    private final SupplierSiteRepository supplierSiteRepository;

    public SupplierSite findById(Long id) {
        Optional<SupplierSite> supplierSite = supplierSiteRepository.findById(id);
        return supplierSite.orElse(null);
    }
}
