package ru.rosatom.edu.bratyshevTD.fileStorage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.rosatom.edu.bratyshevTD.fileStorage.entities.FileStorage;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import ru.rosatom.edu.bratyshevTD.fileStorage.repositories.FileStorageRepository;

@Service
public class FileStorageService {

    private FileStorageRepository fileStorageRepository;

    @Autowired
    public void setFileStorageRepository(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    public Long createFile(FileStorage fileStorage) {

        fileStorage.setCreationDate(new Date());
        System.out.println(fileStorage.toString());
        fileStorageRepository.save(fileStorage);

        return fileStorage.getId();
    }

    public FileStorage getFileById(Long id) {
        return fileStorageRepository.findById(id).get();
    }

    public Page<FileStorage> getAllFiles(Pageable pageable) {
        return fileStorageRepository.findAll(pageable);
    }
}
