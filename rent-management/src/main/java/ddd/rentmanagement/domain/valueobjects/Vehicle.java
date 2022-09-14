package ddd.rentmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ddd.sharedkernel.domain.base.ValueObject;
import ddd.sharedkernel.domain.valueobjects.financial.Money;
import lombok.Getter;

@Getter
public class Vehicle implements ValueObject {

    private final VehicleId vehicleId;

    private final Name name;

    private final Brand brand;

    private final Money price;

    private final Type type;

    private final Integer numOfRents;

    private Vehicle() {
        this.vehicleId = VehicleId.randomId(VehicleId.class);
        this.name = new Name();
        this.price = Money.valueOf(0);
        this.brand = new Brand();
        this.type = Type.CAR;
        this.numOfRents = 0;
    }

    @JsonCreator
    public Vehicle(
            @JsonProperty("id") VehicleId id,
            @JsonProperty("name") Name name,
            @JsonProperty("brand") Brand brand,
            @JsonProperty("amount") Money price,
            @JsonProperty("type") Type type,
            @JsonProperty("numOfRents") Integer numOfRents) {
        this.vehicleId = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.type = type;
        this.numOfRents = numOfRents;
    }
}
