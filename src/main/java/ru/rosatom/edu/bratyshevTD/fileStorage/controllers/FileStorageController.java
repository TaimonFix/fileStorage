package ru.rosatom.edu.bratyshevTD.fileStorage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rosatom.edu.bratyshevTD.fileStorage.entities.FileStorage;
import ru.rosatom.edu.bratyshevTD.fileStorage.services.FileStorageService;

import java.util.Base64;
import java.util.Date;

@RestController
public class FileStorageController {

    private FileStorageService fileStorageService;

    @Autowired
    public void setFileStorageService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/create")
    public Long createFile(FileStorage fileStorage) {
        fileStorage.setFile(Base64.getDecoder().decode(fileStorage.getFile()));
        fileStorage.setCreationDate(new Date());

        return fileStorageService.createFile(fileStorage);
    }

    @GetMapping("/get{id}")
    public FileStorage getFile(@PathVariable Long id) {
        FileStorage fileStorage = fileStorageService.getFileById(id);
        String encodedString = Base64.getEncoder().encodeToString(fileStorage.getFile());
        fileStorage.setFile(encodedString.getBytes());

        return fileStorage;
    }
}
