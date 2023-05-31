package kpfu.itis.sem.util.mapper;

import kpfu.itis.sem.dto.request.CustomerDto;
import kpfu.itis.sem.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface CustomerMapper {

    @Mapping(target = "createDate", ignore = true)
    CustomerEntity toEntity(CustomerDto customerDto);

    CustomerDto toDto(CustomerEntity entity);

}
