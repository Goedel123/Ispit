package com.rad.ispit.service;

import com.rad.ispit.entity.Folder;
import com.rad.ispit.repo.FolderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FolderService implements FolderServiceInterface{
    private final FolderRepo FolderRepo;
    //private final FolderRepo FolderRepo;

    // Create Read Update Remove == CRUD

    public List<Folder> findByParent(int id){
        return FolderRepo.findByParent(id);
    }
    //@Override
    //public Iterable<Folder> getAllFolders(){
        //return FolderRepo.findAll();
    //}

    @Override
    public Folder getFolderById(Integer id){
        System.out.println("\n\n\n\n\no");
        return FolderRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED, "greska."));
    }
    @Override
    public Folder createFolder(Folder folder){
        return FolderRepo.save(folder);
    }

    @Override
    public Folder updateFolder(Integer id, Folder folder){
        Folder a= FolderRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"nema ga"));

        a.setName(folder.getName());
        a.setCreation_time(folder.getCreation_time());
        //a.setParent_id(folder.getParent_id());

        return FolderRepo.save(a);
    }
    @Override
    public void deleteFolder(Integer id){
        FolderRepo.deleteById(id);
    }


}
