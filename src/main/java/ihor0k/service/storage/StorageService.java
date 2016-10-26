package ihor0k.service.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface StorageService {
    void init();

    void store(File file);

    File load(String fileName);

    void delete(String filename);

    void deleteAll();
}
