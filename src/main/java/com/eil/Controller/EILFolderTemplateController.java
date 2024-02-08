package com.eil.Controller;

import com.eil.Entities.EILFolderTemplates;
import com.eil.Services.EILFolderTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
