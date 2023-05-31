package kpfu.itis.sem.service.impl;

import kpfu.itis.sem.dto.request.FileDto;
import kpfu.itis.sem.service.FileService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class BaseFileService implements FileService {

    @Override
    public String save(FileDto fileDto) {

        String originalNameForFile = UUID.randomUUID() + fileDto.getName();

        try {
            Files.copy(fileDto.getInputStream(), Paths.get(fileDto.getStoragePath() + "\\" + originalNameForFile));
            return originalNameForFile;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
