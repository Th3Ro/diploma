package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.model.SupplierXpath;
import ru.doploma.idealcarprice.repository.SupplierXpathRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierXpathService {
    private final SupplierXpathRepository supplierXpathRepository;

    public SupplierXpath findBySupplierSiteId (Long supplierSiteId) {
        Optional<SupplierXpath> supplierXpath = supplierXpathRepository.findBySupplierSiteId(supplierSiteId);
        return supplierXpath.orElse(null);
    }
}
