package com.rad.ispit.repo;

import com.rad.ispit.entity.File;
import com.rad.ispit.entity.Folder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepo extends CrudRepository<Folder,Integer> {

    List<Folder> findByParent(int id);
}
