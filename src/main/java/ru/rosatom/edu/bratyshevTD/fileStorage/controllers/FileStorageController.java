package ru.rosatom.edu.bratyshevTD.fileStorage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rosatom.edu.bratyshevTD.fileStorage.entities.FileStorage;
import ru.rosatom.edu.bratyshevTD.fileStorage.services.FileStorageService;

import java.util.List;

@RestController
public class FileStorageController {

    private FileStorageService fileStorageService;

    @Autowired
    public void setFileStorageService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/files")
    public Page<FileStorage> getAllFiles(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size,
                                         @RequestParam(defaultValue = "creationDate") String sortBy,
                                         @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return fileStorageService.getAllFiles(pageable);
    }

    @PostMapping("/create")
    public Long createFile(@RequestBody FileStorage fileStorage) {
        return fileStorageService.createFile(fileStorage);
    }

    @GetMapping("/get")
    public FileStorage getFile(@RequestParam("id") Long id) {
        FileStorage fileStorage = fileStorageService.getFileById(id);

        return fileStorage;
    }
}
