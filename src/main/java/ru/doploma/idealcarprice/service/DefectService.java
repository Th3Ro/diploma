package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.model.Defect;
import ru.doploma.idealcarprice.repository.DefectRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DefectService {
    private final DefectRepository defectRepository;

    public Defect findByName(String value) {
        Optional<Defect> defect = defectRepository.findByName(value);
        return defect.orElse(null);
    }

    public List<Defect> findAll(){
        return defectRepository.findAll();
    }
}
