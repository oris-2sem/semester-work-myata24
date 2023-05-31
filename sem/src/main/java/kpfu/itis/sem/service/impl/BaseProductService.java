package kpfu.itis.sem.service.impl;


import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.entity.ProductEntity;
import kpfu.itis.sem.repository.ProductRepository;
import kpfu.itis.sem.service.ProductService;
import kpfu.itis.sem.util.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BaseProductService implements ProductService {


    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    @Override
    public List<ProductEntity> showAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean isNotNullProductDto(ProductsDto productsDto) {
        if (productsDto.getCategory() != null && productsDto.getName() != null && productsDto.getIsAvailable() != null
        && productsDto.getCost() != null && productsDto.getCount() != null) {
            if (!productsDto.getCategory().equals("") && !productsDto.getName().equals("") &&
                    !productsDto.getIsAvailable().equals("")
                    && !productsDto.getCost().equals("") && !productsDto.getCount().equals("")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void createProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    @Override
    public ProductEntity getProductById(UUID id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public ProductsDto getProductsDtoById(UUID id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        if (productEntityOptional.isPresent()) {
            ProductEntity product = productEntityOptional.get();

            ProductsDto productsDto = productMapper.toDto(product);
            return productsDto;
        }
        return null;
    }

}
