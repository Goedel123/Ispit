package com.rad.ispit.repo;

import com.rad.ispit.entity.File;
import com.rad.ispit.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepo extends CrudRepository<File,Integer> {

    List<File> findByParent(int id);
}
