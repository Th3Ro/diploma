package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.model.BodyWork;
import ru.doploma.idealcarprice.repository.BodyWorkRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BodyWorkService {
    private final BodyWorkRepository bodyWorkRepository;

    public BodyWork findById(Long id) {
        Optional<BodyWork> bodyWork = bodyWorkRepository.findById(id);
        return bodyWork.orElse(null);
    }

    public BodyWork findByName(String name) {
        Optional<BodyWork> bodyWork = bodyWorkRepository.findByName(name);
        return bodyWork.orElse(null);
    }
}
