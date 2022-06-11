package ddd.vehiclelist.domain.valueobjects;


import ddd.sharedkernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Brand implements ValueObject {

    private final String brand;

    protected Brand(){
        this.brand = "";
    }

}
