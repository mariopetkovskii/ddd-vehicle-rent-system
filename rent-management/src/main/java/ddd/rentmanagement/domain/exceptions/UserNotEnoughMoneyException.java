package ddd.rentmanagement.domain.exceptions;

public class UserNotEnoughMoneyException extends RuntimeException{
    public UserNotEnoughMoneyException() {
        super("You can't rent this car");
    }
}
