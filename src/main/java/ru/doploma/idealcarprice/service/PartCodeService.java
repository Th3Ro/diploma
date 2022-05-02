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
    private PartCodeRepository partCodeRepository;

    public List<PartCode> findAll() {
        return partCodeRepository.findAll();
    }

    // todo потом в стриме перебрать все парткоды и из них вывести все детали, которые будут относиться только к выбранной модели
    public List<PartCode> findAllByModel(Model model) {
        return partCodeRepository.findAllByModel(model);
    }
}
