package ru.rosatom.edu.bratyshevTD.fileStorage.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;


public class FileStorage {

    private Base64 file;
    private String title;
    private Date creationDate;
    private String description;

    public FileStorage(Base64 file, String title, Date creationDate, String description) {
        this.file = file;
        this.title = title;
        this.creationDate = creationDate;
        this.description = description;
    }

    public FileStorage() {
    }

    public Base64 getFile() {
        return file;
    }

    public void setFile(Base64 file) {
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
