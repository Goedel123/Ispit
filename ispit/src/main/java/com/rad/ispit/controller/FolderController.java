package com.rad.ispit.controller;

import com.rad.ispit.entity.File;
import com.rad.ispit.entity.Folder;
import com.rad.ispit.service.FileService;
import com.rad.ispit.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/folder")
public class FolderController {

    private final FolderService service;

    @GetMapping("/s/{id}")
    public List<Folder> findByParent(@PathVariable Integer id){ // @PathVariable
        System.out.println("\n\n\n\nGG");
        return service.findByParent(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Folder> getFileById(@PathVariable Integer id){ // @PathVariable
        System.out.println("\n\n\n\nRG");
        return ResponseEntity.ok(service.getFolderById(id));
    }

    @PostMapping
    public ResponseEntity<Folder> createFile(@RequestBody Folder folder){
        return ResponseEntity.ok(service.createFolder(folder));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Folder> updateFile(@PathVariable int id,@RequestBody Folder folder){
        return ResponseEntity.ok(service.updateFolder(id,folder));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Folder> deleteFile(@PathVariable int id) {
        service.deleteFolder(id);

        return ResponseEntity.noContent().build();
    }
}
