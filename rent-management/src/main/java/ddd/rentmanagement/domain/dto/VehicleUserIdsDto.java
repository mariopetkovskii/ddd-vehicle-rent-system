package ddd.rentmanagement.domain.dto;

import lombok.Getter;

@Getter
public class VehicleUserIdsDto {
    private String userId;
    private String vehicleId;
    private String email;
    private Integer days;
}
