package ru.rosatom.edu.bratyshevTD.fileStorage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosatom.edu.bratyshevTD.fileStorage.entities.FileStorage;

import java.util.Base64;
import java.util.Date;
import ru.rosatom.edu.bratyshevTD.fileStorage.repositories.FileStorageRepository;

@Service
public class FileStorageService {

    private FileStorageRepository fileStorageRepository;

    @Autowired
    public void setFileStorageRepository(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    public Long createFile(FileStorage fileStorage) {
        byte[] decodeFile = Base64.getDecoder().decode(fileStorage.getFile());
        fileStorage.setFile(decodeFile);
        fileStorage.setCreationDate(new Date());
        fileStorageRepository.save(fileStorage);

        return fileStorage.getId();
    }

    public FileStorage getFileById(Long id) {
        return fileStorageRepository.getReferenceById(id);
    }
}
