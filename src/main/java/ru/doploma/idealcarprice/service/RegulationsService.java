package ru.doploma.idealcarprice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.doploma.idealcarprice.model.Regulations;
import ru.doploma.idealcarprice.repository.RegulationsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RegulationsService {
    private final RegulationsRepository regulationsRepository;

    public List<Regulations> findAll() {
        List<Regulations> returnList = regulationsRepository.findAll();
        return returnList;
    }
}
