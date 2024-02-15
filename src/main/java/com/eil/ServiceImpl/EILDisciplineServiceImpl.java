package com.eil.services;

import com.eil.Entities.EILDiscipline;
import com.eil.repositories.EILRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EILDisciplineServiceImpl implements EILDisciplineService {

    private final EILRepository eilRepository;

    @Autowired
    public EILDisciplineServiceImpl(EILRepository eilRepository) {
        this.eilRepository = eilRepository;
    }

    @Override
    public List<EILDiscipline> getAllDisciplines() {
        return eilRepository.findAll();
    }

    @Override
    public EILDiscipline getDisciplineById(String id) {
        return eilRepository.findById(id).orElse(null);
    }

    @Override
    public EILDiscipline saveDiscipline(EILDiscipline discipline) {
        return eilRepository.save(discipline);
    }

    @Override
    public void deleteDiscipline(String id) {
        eilRepository.deleteById(id);
    }
}
