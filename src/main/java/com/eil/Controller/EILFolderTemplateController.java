package com.eil.Controller;

import com.eil.Entities.EILFolderTemplates;
import com.eil.Services.EILFolderTemplateService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{folderId}")
    public ResponseEntity<EILFolderTemplates> getFolderById(@PathVariable Long folderId) {
        EILFolderTemplates folder = folderTemplateService.getFolderById(folderId);
        if (folder != null) {
            return ResponseEntity.ok(folder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-folder")
    @Transactional
    public ResponseEntity<EILFolderTemplates> addFolder(@RequestBody EILFolderTemplates newFolder) {
        try {
            EILFolderTemplates createdFolder = folderTemplateService.addFolder(newFolder);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFolder);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/template/{templateId}")
    public ResponseEntity<List<EILFolderTemplates>> getFoldersByTemplate(@PathVariable String templateId) {
        List<EILFolderTemplates> folders = folderTemplateService.getFoldersByTemplate(templateId);
        return ResponseEntity.ok(folders);
    }

    @PostMapping("/save-folder-with-template")
    @Transactional
    public ResponseEntity<EILFolderTemplates> saveFolderWithTemplate(
            @RequestBody EILFolderTemplates folder,
            @RequestParam String templateId) {
        try {
            EILFolderTemplates createdFolder = folderTemplateService.saveFolderWithTemplate(folder, templateId);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFolder);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

