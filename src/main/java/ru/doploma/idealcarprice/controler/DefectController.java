package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.doploma.idealcarprice.dto.SelectedDefectDTO;
import ru.doploma.idealcarprice.helper.SelectedItemsByUserHelper;
import ru.doploma.idealcarprice.model.Defect;
import ru.doploma.idealcarprice.model.PartCode;
import ru.doploma.idealcarprice.service.DefectService;
import ru.doploma.idealcarprice.service.PartCodeService;

import java.util.List;

@RestController
@AllArgsConstructor
public class DefectController {
    private final DefectService defectService;
    private final PartCodeService partCodeService;

    @GetMapping("/defects")
    public List<Defect> getDefects() {
        return defectService.findAll();
    }

    @PostMapping("/defect")
    public void selectDefect(@RequestBody SelectedDefectDTO dto) {
        PartCode newPartCode = partCodeService.findByDetail_id(dto.detailId);
        if (!dto.value.equals("Ничего (не обязательно)")){
            Defect defect = defectService.findByName(dto.value);
            SelectedItemsByUserHelper.addToSelectedVendorCodesAndDefects(newPartCode.getVendorCode(), defect);
        } else if (SelectedItemsByUserHelper.getSelectedVendorCodesAndDefects().containsKey(newPartCode.getVendorCode())){
            SelectedItemsByUserHelper.removeFromSelectedVendorCodesAndDefects(newPartCode.getVendorCode());
        }
    }

    // todo add logic with parser, search bu vendor code and repair types
}
