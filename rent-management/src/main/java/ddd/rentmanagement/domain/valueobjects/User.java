package ddd.rentmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ddd.sharedkernel.domain.valueobjects.financial.Money;
import lombok.Getter;

@Getter
public class User {
    private final UserId id;

    private final String email;

    private final String firstName;

    private final String lastName;

    private final Money amount;

    private final Integer numOfRents;

    public User() {
        this.id = UserId.randomId(UserId.class);
        this.email = "";
        this.firstName = "";
        this.lastName = "";
        this.amount = Money.valueOf(0);
        this.numOfRents = 0;
    }

    @JsonCreator
    public User(
            @JsonProperty("id") UserId id,
            @JsonProperty("email") String email,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("amount") Money amount,
            @JsonProperty("numOfRents") Integer numOfRents) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        this.numOfRents = numOfRents;
    }
}
