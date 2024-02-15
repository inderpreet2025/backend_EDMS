package com.eil.services;

import com.eil.Entities.EILDiscipline;

import java.util.List;

public interface EILDisciplineService {
    List<EILDiscipline> getAllDisciplines();
    EILDiscipline getDisciplineById(String id);
    EILDiscipline saveDiscipline(EILDiscipline discipline);
    void deleteDiscipline(String id);
}
