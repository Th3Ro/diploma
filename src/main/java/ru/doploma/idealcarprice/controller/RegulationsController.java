package ru.doploma.idealcarprice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.doploma.idealcarprice.dto.SelectRegulationsDTO;
import ru.doploma.idealcarprice.model.Regulations;
import ru.doploma.idealcarprice.service.RegulationsService;

import java.util.List;

@RestController
@AllArgsConstructor
public class RegulationsController {
    private final RegulationsService regulationsService;

    @GetMapping("/regulations")
    public List<Regulations> getRegulations() {
        return regulationsService.findAll();
    }

    @PostMapping("/regulations")
    public void selectRegulations(@RequestBody SelectRegulationsDTO dto) {
        regulationsService.selectRegulations(dto);
    }
}
