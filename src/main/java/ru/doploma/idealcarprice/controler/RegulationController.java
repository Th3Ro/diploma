package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.doploma.idealcarprice.model.Regulations;
import ru.doploma.idealcarprice.service.PartCodeService;
import ru.doploma.idealcarprice.service.RegulationsService;

import java.util.List;

@RestController
@AllArgsConstructor
public class RegulationController {
    private final RegulationsService regulationsService;
    private final PartCodeService partCodeService;

    @GetMapping("/regulations")
    public List<Regulations> getRegulations() {
        return regulationsService.findAll();
    }

//    @PostMapping("/defect")
//    public void selectRegulation(@RequestBody SelectedDefectDTO dto) {
//        PartCode newPartCode = partCodeService.findByDetail_id(dto.detailId);
//        if (!dto.value.equals("Ничего (не обязательно)")){
//            Defect defect = defectService.findByName(dto.value);
//            SelectedItemsByUserHelper.addToSelectedVendorCodesAndRegulations(newPartCode.getVendorCode(), defect);
//        } else if (SelectedItemsByUserHelper.getSelectedVendorCodesAndRegulations().containsKey(newPartCode.getVendorCode())){
//            SelectedItemsByUserHelper.removeFromSelectedVendorCodesAndRegulations(newPartCode.getVendorCode());
//        }
//    }

    // todo add logic with parser, search bu vendor code and repair types
}
