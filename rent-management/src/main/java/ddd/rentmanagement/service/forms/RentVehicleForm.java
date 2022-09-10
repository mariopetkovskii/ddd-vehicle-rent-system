package ddd.rentmanagement.service.forms;


import ddd.rentmanagement.domain.valueobjects.Vehicle;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class RentVehicleForm {

    @NotNull
    private Vehicle vehicle;

    @Min(1)
    private int daysRent = 1;
}
