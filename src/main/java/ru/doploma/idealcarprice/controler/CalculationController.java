package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.dto.CalculationDTO;
import ru.doploma.idealcarprice.service.CalculationService;

@RestController
@AllArgsConstructor
public class CalculationController {
    private final CalculationService calculationService;

    @GetMapping("/calculation")
    public CalculationDTO getCalculationResult () {
        return calculationService.getCalculationResult();
    }
}
