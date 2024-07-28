package ru.rosatom.edu.bratyshevTD.fileStorage.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity(name = "file_storage")
public class FileStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "file")
    private byte[] file;
    @Column(name = "title")
    private String title;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "description")
    private String description;

    public FileStorage(Long id, byte[] file, String title, Date creationDate, String description) {
        Id = id;
        this.file = file;
        this.title = title;
        this.creationDate = creationDate;
        this.description = description;
    }

    public FileStorage() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
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
