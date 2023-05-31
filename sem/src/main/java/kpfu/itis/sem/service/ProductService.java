package kpfu.itis.sem.service;


import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

    List<ProductEntity> showAllProducts();

    boolean isNotNullProductDto(ProductsDto productsDto);

    void createProduct(ProductEntity productEntity);

    ProductEntity getProductById(UUID id);

    ProductsDto getProductsDtoById(UUID id);


}
