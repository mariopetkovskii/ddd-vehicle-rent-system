package ddd.vehiclelist.domain.exceptions;

public class VehicleNotAvailableException extends RuntimeException{
    public VehicleNotAvailableException() {
        super("vehicle not available");
    }
}
