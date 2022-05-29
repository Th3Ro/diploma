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

    public List<PartCode> findByDetail_id(Long id) {
        return partCodeRepository.findByDetail_Id(id);
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

    public List<PartCode> findAllByDetail_idAndModel_id(Long detailId, Long modelId) {
        return partCodeRepository.findAllByDetail_idAndModel_id(detailId, modelId);
    }
}
