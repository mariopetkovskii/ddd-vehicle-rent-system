package ddd.rentmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import ddd.sharedkernel.domain.base.ValueObject;
import ddd.sharedkernel.domain.valueobjects.financial.Money;
import lombok.Getter;

@Getter
public class Vehicle implements ValueObject {

    private final VehicleId id;

    private final String name;

    private final Money price;

    private Vehicle() {
        this.id = VehicleId.randomId(VehicleId.class);
        this.name = "";
        this.price = Money.valueOf(0);
    }

    @JsonCreator
    public Vehicle(VehicleId id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
