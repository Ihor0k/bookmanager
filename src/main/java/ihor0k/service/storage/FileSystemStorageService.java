package ihor0k.service.storage;

import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

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
    public void store(File file) {
        try {
            Files.copy(file.toPath(), rootLocation.resolve(file.getName()));
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getName(), e);
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
    public void delete(String filename) {
        File file = rootLocation.resolve(filename).toFile();
        if (file.exists()) {
            if (!file.delete())
                throw new StorageException("Could not delete file: " + filename);
        } else
            throw new StorageFileNotFoundException("File '" + file + "' not found");
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void setRootLocation(Path rootLocation) {
        this.rootLocation = rootLocation;
    }
}
