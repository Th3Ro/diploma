package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.doploma.idealcarprice.dto.SelectRegulationsDTO;
import ru.doploma.idealcarprice.helper.SelectedItemsByUserHelper;
import ru.doploma.idealcarprice.model.Detail;
import ru.doploma.idealcarprice.model.PartCode;
import ru.doploma.idealcarprice.model.Regulations;
import ru.doploma.idealcarprice.service.PartCodeService;
import ru.doploma.idealcarprice.service.RegulationsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class RegulationsController {
    private final RegulationsService regulationsService;
    private final PartCodeService partCodeService;

    @GetMapping("/regulations")
    public List<Regulations> getRegulations() {
        return regulationsService.findAll();
    }

    @PostMapping("/regulations")
    public void selectRegulations(@RequestBody SelectRegulationsDTO dto) {
        Regulations selectedRegulations = regulationsService.findById(Long.parseLong(dto.regulationsId));
        if (selectedRegulations != null && dto.isChecked) {
            List<PartCode> vendorCodes = new ArrayList<>();
            for (Detail detail: selectedRegulations.getDetails()) {
                vendorCodes.addAll(partCodeService.findAllByDetail_idAndModel_id(
                        detail.getId(),
                        SelectedItemsByUserHelper.getSelectedModel().getId()));
            }
            SelectedItemsByUserHelper.addToSelectedVendorCodesAndRegulations(selectedRegulations.getId().toString(), vendorCodes);
        } else {
            try {
                SelectedItemsByUserHelper.removeFromSelectedVendorCodesAndRegulations(dto.regulationsId);
            } catch (NullPointerException ex) {
                System.out.println("Нет такого регламента");
            }
        }
    }
}
