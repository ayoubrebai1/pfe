package com.kripton.gestionbudget.Interface;

import com.kripton.gestionbudget.entities.FileDB;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesStorageInterface {

        public void init();

        public void save(MultipartFile file);

        public Resource load(String filename);

        public void deleteAll();

        public Stream<Path> loadAll();

        public FileDB getFile(String id) ;


}
