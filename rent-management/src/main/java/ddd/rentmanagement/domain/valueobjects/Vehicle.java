package ddd.rentmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ddd.sharedkernel.domain.base.ValueObject;
import ddd.sharedkernel.domain.valueobjects.financial.Money;
import lombok.Getter;

@Getter
public class Vehicle implements ValueObject {

    private final VehicleId id;

    private final Name name;

    private final Brand brand;

    private final Money price;

    private final Type type;

    private Vehicle() {
        this.id = VehicleId.randomId(VehicleId.class);
        this.name = new Name();
        this.price = Money.valueOf(0);
        this.brand = new Brand();
        this.type = Type.CAR;
    }

    @JsonCreator
    public Vehicle(
            @JsonProperty("id") VehicleId id,
            @JsonProperty("name") Name name,
            @JsonProperty("brand") Brand brand,
            @JsonProperty("amount") Money price,
            @JsonProperty("type") Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.type = type;
    }
}
