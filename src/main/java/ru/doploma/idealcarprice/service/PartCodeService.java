package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.model.Model;
import ru.doploma.idealcarprice.model.PartCode;
import ru.doploma.idealcarprice.repository.PartCodeRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PartCodeService {
    private final PartCodeRepository partCodeRepository;

    public PartCode findByDetail_id(Long id) {
        Optional<PartCode> partCode = partCodeRepository.findByDetail_Id(id);
        return partCode.orElse(null);
    }

    public List<PartCode> findAllByModel_id(Long id) {
        return partCodeRepository.findAllByModel_id(id);
    }

    public List<PartCode> findAll() {
        return partCodeRepository.findAll();
    }

    public List<PartCode> findAllByModel(Model model) {
        return partCodeRepository.findAllByModel(model);
    }
}
