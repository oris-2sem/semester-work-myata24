package kpfu.itis.sem.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class CustomerDto {

    private UUID id;

    private String name;

    private String phoneNumber;

    private String status;

}
