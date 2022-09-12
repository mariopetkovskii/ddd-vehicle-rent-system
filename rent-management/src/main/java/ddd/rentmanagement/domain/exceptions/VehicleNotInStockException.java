package ddd.rentmanagement.domain.exceptions;

public class VehicleNotInStockException extends RuntimeException{
    public VehicleNotInStockException() {
        super("Vehicle not available at this moment");
    }
}
