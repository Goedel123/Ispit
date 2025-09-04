package com.rad.ispit.controller;

import com.rad.ispit.entity.File;
import com.rad.ispit.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/file")
public class FileController {

    private final FileService service;

    @GetMapping("/s/{id}")
    public List<File> findByParent(@PathVariable Integer id){ // @PathVariable
        System.out.println("\n\n\n\nGG");
        return service.findByParent(id);
    }
    @GetMapping
    public ResponseEntity<Iterable<File>> getAllFiles(){
        return ResponseEntity.ok(service.getAllFiles());
    }
    /*
    @GetMapping("/s/{id}")
    public ResponseEntity<File> getByParentId(@PathVariable Integer id){ // @PathVariable
        System.out.println("\n\n\n\nGG");
        return ResponseEntity.ok(service.getFileById(id));
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<File> getFileById(@PathVariable Integer id){ // @PathVariable
        System.out.println("\n\n\n\nRG");
        return ResponseEntity.ok(service.getFileById(id));
    }

    @PostMapping
    public ResponseEntity<File> createFile(@RequestBody File file){
        return ResponseEntity.ok(service.createFile(file));
    }
    @PutMapping()
    public ResponseEntity<File> updateFile(@PathVariable int id,@RequestBody File file){
        return ResponseEntity.ok(service.updateFile(id,file));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<File> deleteFile(@PathVariable int id) {
        service.deleteFile(id);

        return ResponseEntity.noContent().build();
    }
}
