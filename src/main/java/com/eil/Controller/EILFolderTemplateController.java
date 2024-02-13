package com.eil.Controller;

import com.eil.Entities.EILFolderTemplates;
import com.eil.Services.EILFolderTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<Void> addFolderTemplate(@RequestBody EILFolderTemplates folderTemplate) {
        EILFolderTemplates createdFolderTemplate = folderTemplateService.addFolderTemplate(folderTemplate);

        // URI of the newly created resource in the response headers is returned
        URI location = URI.create("/api/folder-templates/" + createdFolderTemplate.getTemplateId());
        return ResponseEntity.created(location).build();
    }
}
