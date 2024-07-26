package ru.rosatom.edu.bratyshevTD.fileStorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rosatom.edu.bratyshevTD.fileStorage.entities.FileStorage;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {
}
