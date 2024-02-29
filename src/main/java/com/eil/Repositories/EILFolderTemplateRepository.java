package com.eil.Repositories;

import com.eil.Entities.EILFolderTemplates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EILFolderTemplateRepository extends JpaRepository<EILFolderTemplates, String> {

    List<EILFolderTemplates> findByTemplateId(String templateId);
}

