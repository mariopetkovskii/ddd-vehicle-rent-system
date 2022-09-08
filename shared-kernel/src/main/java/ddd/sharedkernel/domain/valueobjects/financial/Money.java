package ddd.sharedkernel.domain.valueobjects.financial;

import ddd.sharedkernel.domain.base.ValueObject;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Money implements ValueObject {

    private final Double amount;

    protected Money(){
        this.amount = 0.0;
    }

    public Money(@NonNull Double money){
        this.amount = money;
    }

    public Money add(Money money){
        return new Money(amount + money.amount);
    }

    public Money subtract(Money money){
        return new Money(amount - money.amount);
    }

    public Money multiply(int m){
        return new Money(amount * m);
    }

    public static Money valueOf(double amount){
        return new Money(amount);
    }
}
