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
    private final ModelRepository modelRepository;

    public List<Model> findAllByBrand(Brand brand) {
        return modelRepository.findAllByBrand(brand);
    }

    public Model findById(Long id) {
        return modelRepository.findById(id).isPresent() ? modelRepository.findById(id).get() : null;
    }
}
