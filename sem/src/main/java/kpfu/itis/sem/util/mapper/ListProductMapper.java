package kpfu.itis.sem.util.mapper;

import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ListProductMapper {

    List<ProductsDto> mupStruct(List<ProductEntity> allProducts);
}
