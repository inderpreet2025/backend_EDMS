package com.eil.Services;

import com.eil.Entities.EILFolderTemplates;
import com.eil.Repositories.EILFolderTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public EILFolderTemplates addFolderTemplate(EILFolderTemplates folderTemplate) {
        // Generate a unique ID for the new folder template
        String newTemplateId = UUID.randomUUID().toString();
        folderTemplate.setTemplateId(newTemplateId);

        // Set the creation date
        folderTemplate.setCreationDate(new Timestamp(System.currentTimeMillis()));

        // If the folder has a parent folder, set the hierarchical relationship
        if (folderTemplate.getTmplParentFolderId() != null) {
            //  assume the parent folder is already in the database
            // and has a valid ID.

            // Set the hierarchical relationship
            EILFolderTemplates parentFolder = folderTemplateRepository.findById(folderTemplate.getTmplParentFolderId()).orElse(null);
            if (parentFolder != null) {
                folderTemplate.setTmplParentFolderId(parentFolder.getTemplateId());
            }
        }

        // Save the folder template to the database using the repository
        EILFolderTemplates createdFolderTemplate = folderTemplateRepository.save(folderTemplate);

        // Return the created folder template
        return createdFolderTemplate;
    }
}
