package com.eil.Services;

import com.eil.Entities.EILFolderTemplates;
import com.eil.Repositories.EILFolderTemplateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class EILFolderTemplateService {

    @Autowired
    private EILFolderTemplateRepository folderTemplateRepository;

    public List<EILFolderTemplates> getAllFolderTemplates() {
        return folderTemplateRepository.findAll();
    }


    public EILFolderTemplates addFolderTemplate(EILFolderTemplates folderTemplate) throws ChangeSetPersister.NotFoundException {
        folderTemplate.setCreationDate(new Timestamp(System.currentTimeMillis()));

        if (folderTemplate.getTmplParentFolderId() != null) {
            EILFolderTemplates parentFolder = folderTemplateRepository.findById(folderTemplate.getTmplParentFolderId()).orElse(null);

            if (parentFolder != null) {
                folderTemplate.setTmplParentFolderId(parentFolder.getTemplateId());
            } else {
                folderTemplate.setTmplParentFolderId(null);
            }
        }

        EILFolderTemplates createdFolderTemplate = folderTemplateRepository.save(folderTemplate);

        return createdFolderTemplate;
    }

}
