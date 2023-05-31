package kpfu.itis.sem.service;

import kpfu.itis.sem.entity.DescriptionEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface DescriptionService {

    DescriptionEntity getDescriptionByProductId(UUID id);

}
