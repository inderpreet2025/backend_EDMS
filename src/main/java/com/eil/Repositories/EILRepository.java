package com.eil.repositories;

import com.eil.Entities.EILDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EILRepository extends JpaRepository<EILDiscipline, String> {
    List<EILDiscipline> findByDivisionName(String divisionName);
    List<EILDiscipline> findByDepartmentName(String departmentName);
    EILDiscipline findByTemplateId(String templateId);
    List<EILDiscipline> findByDiscontinued(boolean discontinued);
    List<EILDiscipline> findByDontWorkInEDMS(boolean dontWorkInEDMS);
}
