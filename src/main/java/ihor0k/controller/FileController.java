package ihor0k.controller;

import ihor0k.service.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FileController {
    private StorageService storageService;

    @RequestMapping(value = "/file/{file_name:.+\\.pdf}", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {
        response.setHeader("Content-Disposition", "inline; filename=" + fileName);
        return new FileSystemResource(storageService.load(fileName));
    }

    @Autowired
    @Qualifier(value = "fileSystemStorageService")
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
