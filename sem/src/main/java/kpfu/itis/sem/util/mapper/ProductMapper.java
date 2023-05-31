package kpfu.itis.sem.util.mapper;

import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "createDate", ignore = true)
    ProductEntity toEntity(ProductsDto productsDto);

    ProductsDto toDto(ProductEntity entity);

}

