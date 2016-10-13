package ihor0k.storage;

import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileSystemStorageService implements StorageService {
    private Path rootLocation;

    @Override
    public void init() {
        if (Files.notExists(rootLocation))
            try {
                Files.createDirectory(rootLocation);
            } catch (IOException e) {
                throw new StorageException("Could not initialize storage", e);
            }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public File load(String fileName) {
        File file = rootLocation.resolve(fileName).toFile();
        if (file.exists())
            return file;
        else throw new StorageFileNotFoundException("Could not read file: " + fileName);
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void setRootLocation(Path rootLocation) {
        this.rootLocation = rootLocation;
    }
}
