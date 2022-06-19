package ru.doploma.idealcarprice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.dto.SelectBodyWorkDTO;
import ru.doploma.idealcarprice.service.BodyWorkService;

@RestController
@AllArgsConstructor
public class BodyWorkController {
    private BodyWorkService bodyWorkService;

    @PostMapping("/bodyWork")
    public void selectBodyWork(@RequestBody SelectBodyWorkDTO dto) {
        bodyWorkService.selectBodyWork(dto);
    }
}
