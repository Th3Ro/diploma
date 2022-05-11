package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.model.Defect;
import ru.doploma.idealcarprice.service.DefectService;

import java.util.List;

@RestController
@AllArgsConstructor
public class DefectController {
    private final DefectService defectService;

    @GetMapping("/defects")
    public List<Defect> getDefects() {
        return defectService.findAll();
    }

    // todo add logic for change defects state and maybe create dto's for models
}
