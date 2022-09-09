package ddd.vehiclelist.service.form;

import ddd.sharedkernel.domain.valueobjects.financial.Money;
import ddd.vehiclelist.domain.valueobjects.Brand;
import ddd.vehiclelist.domain.valueobjects.Name;
import ddd.vehiclelist.domain.valueobjects.Type;
import lombok.Data;

@Data
public class VehicleForm {

    private Name name;
    private Brand brand;
    private Money price;
    private Type type;
    private int numOfRents;

}
