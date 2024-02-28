package com.eil.Services;

import com.eil.Entities.EILFolderTemplates;
import com.eil.Repositories.EILFolderTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

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
            if (newFolder.getTmplParentFolderId() != 0) {
                setParentFolderId(newFolder);
            } else {
                newFolder.setTmplParentFolderId(Integer.parseInt("root_folder"));
            }

            EILFolderTemplates createdFolder = folderTemplateRepository.save(newFolder);
            return createdFolder;
        } catch (Exception e) {
            throw new RuntimeException("Not able to add folder!");
        }
    }

    public EILFolderTemplates saveFolderWithTemplate(EILFolderTemplates folder, int template) {
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
            folderTemplate.setTmplParentFolderId(Integer.parseInt("root_folder"));
        }
    }
}
