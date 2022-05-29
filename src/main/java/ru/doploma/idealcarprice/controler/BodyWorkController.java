package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.dto.SelectBodyWorkDTO;
import ru.doploma.idealcarprice.helper.SelectedItemsByUserHelper;
import ru.doploma.idealcarprice.model.BodyWork;
import ru.doploma.idealcarprice.model.Detail;
import ru.doploma.idealcarprice.model.PartCode;
import ru.doploma.idealcarprice.model.Regulations;
import ru.doploma.idealcarprice.service.BodyWorkService;
import ru.doploma.idealcarprice.service.PartCodeService;
import ru.doploma.idealcarprice.service.RegulationsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class BodyWorkController {
    private BodyWorkService bodyWorkService;
    private RegulationsService regulationsService;
    private PartCodeService partCodeService;

    @PostMapping("/bodyWork")
    public void selectBodyWork(@RequestBody SelectBodyWorkDTO dto) {
        Regulations selectedRegulations = regulationsService.findById(Long.parseLong(dto.regulationsId));
        BodyWork bodyWork = bodyWorkService.findByName(dto.bodyWorkName);
        if (selectedRegulations != null && bodyWork != null) {
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
