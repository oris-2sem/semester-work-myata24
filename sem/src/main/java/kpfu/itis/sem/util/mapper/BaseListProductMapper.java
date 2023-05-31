package kpfu.itis.sem.util.mapper;

import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BaseListProductMapper implements ListProductMapper{
    @Override
    public List<ProductsDto> mupStruct(List<ProductEntity> allProducts) {
        List<ProductsDto> products = new ArrayList<>();
        for (ProductEntity product : allProducts) {
            ProductsDto productsDto = ProductsDto.builder()
                    .category(product.getCategory())
                    .cost(product.getCost())
                    .count(product.getCount())
                    .isAvailable(product.getIsAvailable())
                    .name(product.getName())
                    .pictures(product.getPictures())
                    .build();
            products.add(productsDto);
        }
        return products;
    }
}
