package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.model.Detail;
import ru.doploma.idealcarprice.model.PartCode;
import ru.doploma.idealcarprice.service.PartCodeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class DetailController {
    private final PartCodeService partCodeService;

    @PostMapping("/details")
    public List<Detail> getDetails(@RequestBody String modelId) {
        try {
            return partCodeService.findAllByModel_id(Long.parseLong(modelId)).stream()
                    .map(PartCode::getDetail)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
