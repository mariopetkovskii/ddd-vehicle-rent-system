package ddd.rentmanagement.service.forms;


import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class RentForm {

    private String userId;

    @Valid
    @NotEmpty
    private List<RentVehicleForm> items = new ArrayList<>();
}
