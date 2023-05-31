package kpfu.itis.sem.dto.request;

import kpfu.itis.sem.entity.DescriptionEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Builder
@Getter
@Setter
public class ProductsDto {

    private UUID id;

    private String name;

//    private DescriptionDto description;



    private Integer cost;

    private String category;

    private Boolean isAvailable;

    private Integer count;

    private String pictures;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsDto that = (ProductsDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
