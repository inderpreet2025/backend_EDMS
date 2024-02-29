package com.eil.Services;

import com.eil.Entities.EILFolderTemplates;
import com.eil.Repositories.EILFolderTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class EILFolderTemplateService {

    @Autowired
    private EILFolderTemplateRepository folderTemplateRepository;

    public List<EILFolderTemplates> getAllFolderTemplates() {
        return folderTemplateRepository.findAll();
    }

    public EILFolderTemplates addFolder(EILFolderTemplates newFolder) {
        try {
            newFolder.setCreationDate(new Timestamp(System.currentTimeMillis()));
            if (newFolder.getTmplParentFolderId() != null) {
                setParentFolderId(newFolder);
            } else {
                newFolder.setTmplParentFolderId("root_folder");
            }

            EILFolderTemplates createdFolder = folderTemplateRepository.save(newFolder);
            return createdFolder;
        } catch (Exception e) {
            throw new RuntimeException("Not able to add folder!");
        }
    }

    public EILFolderTemplates saveFolderWithTemplate(EILFolderTemplates folder, String template) {
        try {
            folder.setCreationDate(new Timestamp(System.currentTimeMillis()));
            folder.setTemplateId(template);
            EILFolderTemplates createdFolder = folderTemplateRepository.save(folder);
            return createdFolder;
        } catch (Exception e) {
            throw new RuntimeException("Changes not saved!");
        }
    }

    private void setParentFolderId(EILFolderTemplates folderTemplate) {
        EILFolderTemplates parentFolder = folderTemplateRepository.findById(String.valueOf(folderTemplate.getTmplParentFolderId())).orElse(null);

        if (parentFolder != null) {
            folderTemplate.setTmplParentFolderId(parentFolder.getTemplateId());
        } else {
            folderTemplate.setTmplParentFolderId("root_folder");
        }
    }

    public EILFolderTemplates getFolderById(Long folderId) {
        Optional<EILFolderTemplates> folder = folderTemplateRepository.findById(folderId.toString());
        return folder.orElse(null);
    }

    public List<EILFolderTemplates> getFoldersByTemplate(int templateId) {
        return folderTemplateRepository.findByTemplateId(templateId);
    }
}
