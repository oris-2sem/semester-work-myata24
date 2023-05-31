package kpfu.itis.sem.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class DescriptionDto {

    private UUID id;

    private Integer minWeight;

    private String metal;

    private String insertion;

    private String mechanism;

    private String gender;
}
