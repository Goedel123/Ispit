package com.rad.ispit.service;

import com.rad.ispit.entity.Folder;
import com.rad.ispit.repo.FileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.rad.ispit.entity.File;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FileService implements FileServiceInterface{
    private final FileRepo FileRepo;
    //private final FolderRepo FolderRepo;

    // Create Read Update Remove == CRUD

    //@Override
    public List<File> findByParent(int id){
        return FileRepo.findByParent(id);
    }
    public Iterable<File> getAllFiles(){
        return FileRepo.findAll();
    }

    @Override
    public File getFileById(Integer id){
        System.out.println("\n\n\n\n\no");
        return FileRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED, "greska."));
    }
    @Override
    public File createFile(File file){
        return FileRepo.save(file);
    }
    @Override
    public File updateFile(Integer id, File file){
        File a= FileRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"nema ga"));

        a.setName(file.getName());
        a.setContent(file.getContent());
        a.setCreation_time(file.getCreation_time());
        a.setParent(file.getParent());

        return FileRepo.save(a);
    }
    @Override
    public void deleteFile(Integer id){
        FileRepo.deleteById(id);
    }


}
