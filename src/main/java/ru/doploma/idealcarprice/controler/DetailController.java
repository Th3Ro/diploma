package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.model.Detail;
import ru.doploma.idealcarprice.model.Model;
import ru.doploma.idealcarprice.model.PartCode;
import ru.doploma.idealcarprice.service.ModelService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class DetailController {
    ModelService modelService;

    @PostMapping("/details")
    public List<Detail> getDetails(@RequestBody String modelId) {
        try {
            Model model = modelService.findById(Long.parseLong(modelId));
            return model.getPartCodes().stream()
                    .map(PartCode::getDetail)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
