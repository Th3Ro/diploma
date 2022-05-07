package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.model.Model;
import ru.doploma.idealcarprice.model.PartCode;
import ru.doploma.idealcarprice.repository.PartCodeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PartCodeService {
    private final PartCodeRepository partCodeRepository;

    public List<PartCode> findAll() {
        return partCodeRepository.findAll();
    }

    public List<PartCode> findAllByModel(Model model) {
        return partCodeRepository.findAllByModel(model);
    }
}
