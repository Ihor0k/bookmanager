package ihor0k.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface StorageService {
    void init();
    void store(MultipartFile file);
    File load(String fileName);
    void deleteAll();
}
