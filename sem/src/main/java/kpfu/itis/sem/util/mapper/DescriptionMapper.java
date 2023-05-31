package kpfu.itis.sem.util.mapper;

import kpfu.itis.sem.dto.request.DescriptionDto;
import kpfu.itis.sem.entity.DescriptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DescriptionMapper {

    @Mapping(target = "createDate", ignore = true)
    DescriptionEntity toEntity(DescriptionDto descriptionDto);

    DescriptionDto toDto(DescriptionEntity entity);

}
