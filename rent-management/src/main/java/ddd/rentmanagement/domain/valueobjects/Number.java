package ddd.rentmanagement.domain.valueobjects;

import ddd.sharedkernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Number implements ValueObject {

    private final Integer number;

    protected Number(){
        this.number = 0;
    }

}
