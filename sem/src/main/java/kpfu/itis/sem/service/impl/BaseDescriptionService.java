package kpfu.itis.sem.service.impl;


import kpfu.itis.sem.entity.DescriptionEntity;
import kpfu.itis.sem.entity.ProductEntity;
import kpfu.itis.sem.repository.DescriptionRepository;
import kpfu.itis.sem.service.DescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BaseDescriptionService implements DescriptionService {

    private final DescriptionRepository descriptionRepository;

    private final BaseProductService productService;



    @Override
    public DescriptionEntity getDescriptionByProductId(UUID id) {
        DescriptionEntity description = descriptionRepository.findByProductId(productService.getProductById(id)).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Description not found"));
        return description;
    }

}
