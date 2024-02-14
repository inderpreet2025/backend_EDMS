package com.eil.Controller;

import com.eil.Entities.EILFolderTemplates;
import com.eil.Services.EILFolderTemplateService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/folder-templates")
public class EILFolderTemplateController {

    @Autowired
    private EILFolderTemplateService folderTemplateService;

    @GetMapping
    public ResponseEntity<List<EILFolderTemplates>> getAllFolderTemplates() {
        List<EILFolderTemplates> folderTemplates = folderTemplateService.getAllFolderTemplates();
        return ResponseEntity.ok(folderTemplates);
    }


    @PostMapping
    @Transactional
    public ResponseEntity<EILFolderTemplates> addFolderTemplate(@RequestBody EILFolderTemplates folderTemplate) throws ChangeSetPersister.NotFoundException {
        try {
            System.out.println("Received templateId: " + folderTemplate.getTemplateId());


            folderTemplate.setTemplateId(folderTemplate.getTemplateId().trim());

            EILFolderTemplates createdFolderTemplate = folderTemplateService.addFolderTemplate(folderTemplate);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdFolderTemplate);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ChangeSetPersister.NotFoundException();
        }
    }


}


