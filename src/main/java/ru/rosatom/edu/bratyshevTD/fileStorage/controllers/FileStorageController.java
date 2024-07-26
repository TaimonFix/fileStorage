package ru.rosatom.edu.bratyshevTD.fileStorage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/p")
    public FileStorage test() {

        return new FileStorage(Base64.getEncoder(), "название", new Date(), "Описание");
    }
}
