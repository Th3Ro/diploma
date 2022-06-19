package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.dto.SelectBodyWorkDTO;
import ru.doploma.idealcarprice.helper.SelectedItemsByUserHelper;
import ru.doploma.idealcarprice.model.BodyWork;
import ru.doploma.idealcarprice.model.Detail;
import ru.doploma.idealcarprice.model.PartCode;
import ru.doploma.idealcarprice.model.Regulations;
import ru.doploma.idealcarprice.repository.BodyWorkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BodyWorkService {
    private final BodyWorkRepository bodyWorkRepository;
    private RegulationsService regulationsService;
    private PartCodeService partCodeService;

    public BodyWork findById(Long id) {
        Optional<BodyWork> bodyWork = bodyWorkRepository.findById(id);
        return bodyWork.orElse(null);
    }

    public BodyWork findByName(String name) {
        Optional<BodyWork> bodyWork = bodyWorkRepository.findByName(name);
        return bodyWork.orElse(null);
    }

    public void selectBodyWork(SelectBodyWorkDTO dto) {
        Regulations selectedRegulations = regulationsService.findById(Long.parseLong(dto.regulationsId));
        BodyWork bodyWork = findByName(dto.bodyWorkName);
        if (selectedRegulations != null && bodyWork != null) {
            List<PartCode> vendorCodes = new ArrayList<>();
            for (Detail detail: selectedRegulations.getDetails()) {
                vendorCodes.addAll(partCodeService.findAllByDetail_idAndModel_id(
                        detail.getId(),
                        SelectedItemsByUserHelper.getSelectedModel().getId()));
            }
            SelectedItemsByUserHelper.addToSelectedBodyWorks(selectedRegulations.getId(), bodyWork);
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
