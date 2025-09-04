package com.rad.ispit.service;

import com.rad.ispit.entity.File;
import com.rad.ispit.entity.Folder;

import java.util.List;

public interface FolderServiceInterface {

    List<Folder> findByParent(int value);
    Folder getFolderById(Integer id);
    Folder createFolder(Folder file);
    Folder updateFolder(Integer id, Folder folder);
    void deleteFolder(Integer id);


}
