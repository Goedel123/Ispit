package com.rad.ispit.service;

import com.rad.ispit.entity.File;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface FileServiceInterface {

    File getFileById(Integer id);
    File createFile(File file);
    File updateFile(Integer id, File file);
    void deleteFile(Integer id);


}
