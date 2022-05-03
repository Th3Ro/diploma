package ru.doploma.idealcarprice.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.doploma.idealcarprice.model.Model;
import ru.doploma.idealcarprice.service.ModelService;

import java.util.List;

@RestController
@AllArgsConstructor
public class DetailController {
    ModelService modelService;

    // todo create logic
//    @PostMapping("/details")
//    public List<Model> getModels(@RequestBody Long modelId) {
//        Model model = modelService.findById(modelId);
//        model.get
//
//        return models;
//    }
}
