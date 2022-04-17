package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.model.Brand;
import ru.doploma.idealcarprice.model.Model;
import ru.doploma.idealcarprice.repository.ModelRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelService {
    private ModelRepository modelRepository;

    public List<Model> findAllByBrand(Brand brand) {
        return modelRepository.findAllByBrand(brand);
    }
}
