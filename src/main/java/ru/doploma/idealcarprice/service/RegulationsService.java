package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.dto.SelectRegulationsDTO;
import ru.doploma.idealcarprice.helper.SelectedItemsByUserHelper;
import ru.doploma.idealcarprice.model.Detail;
import ru.doploma.idealcarprice.model.PartCode;
import ru.doploma.idealcarprice.model.Regulations;
import ru.doploma.idealcarprice.repository.RegulationsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegulationsService {
    private final RegulationsRepository regulationsRepository;
    private final PartCodeService partCodeService;

    public Regulations findById(Long id) {
        Optional<Regulations> regulations = regulationsRepository.findById(id);
        return regulations.orElse(null);
    }

    public List<Regulations> findAll() {
        return regulationsRepository.findAll();
    }

    public void selectRegulations(SelectRegulationsDTO dto) {
        Regulations selectedRegulations = findById(Long.parseLong(dto.regulationsId));
        if (selectedRegulations != null && dto.isChecked) {
            List<PartCode> vendorCodes = new ArrayList<>();
            for (Detail detail: selectedRegulations.getDetails()) {
                vendorCodes.addAll(partCodeService.findAllByDetail_idAndModel_id(
                        detail.getId(),
                        SelectedItemsByUserHelper.getSelectedModel().getId()));
            }
            SelectedItemsByUserHelper.addToSelectedVendorCodesAndRegulations(selectedRegulations.getId(), vendorCodes);
        } else {
            try {
                SelectedItemsByUserHelper.removeFromSelectedVendorCodesAndRegulations(dto.regulationsId);
            } catch (NullPointerException ex) {
                System.out.println("Нет такого регламента");
            }
        }
    }
}
