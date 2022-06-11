package ddd.sharedkernel.domain.valueobjects;

import ddd.sharedkernel.domain.base.ValueObject;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class NumberOfRents implements ValueObject {
    private final Integer number;

    protected NumberOfRents(){
        this.number = 0;
    }

    public NumberOfRents(@NonNull Integer number) {
        this.number = number;
    }

    public static NumberOfRents valueOf(Integer number){
        return new NumberOfRents(number);
    }

    public NumberOfRents add(){
        return new NumberOfRents(number + 1);
    }

    public NumberOfRents subtract(){
        return new NumberOfRents(number - 1);
    }
}
