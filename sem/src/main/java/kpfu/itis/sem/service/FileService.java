package kpfu.itis.sem.service;

import kpfu.itis.sem.dto.request.FileDto;
import org.springframework.stereotype.Service;

@Service
public interface FileService {

    String save(FileDto fileDto);


}
