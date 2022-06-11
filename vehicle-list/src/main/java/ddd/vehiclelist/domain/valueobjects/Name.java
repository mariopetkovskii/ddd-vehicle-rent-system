package ddd.vehiclelist.domain.valueobjects;

import ddd.sharedkernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Name implements ValueObject {

    private final String name;

    protected Name(){
        this.name = "";
    }
}
