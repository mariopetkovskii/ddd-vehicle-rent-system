package ddd.rentmanagement.service;

import ddd.rentmanagement.domain.dto.VehicleIdDto;
import ddd.rentmanagement.domain.exceptions.RentIdNotExistException;
import ddd.rentmanagement.domain.exceptions.RentVehicleIdNotExistException;
import ddd.rentmanagement.domain.model.Rent;
import ddd.rentmanagement.domain.model.RentId;
import ddd.rentmanagement.domain.model.RentVehicleId;
import ddd.rentmanagement.service.forms.RentForm;
import ddd.rentmanagement.service.forms.RentVehicleForm;

import java.util.List;
import java.util.Optional;

public interface RentService {
    RentId rent(RentForm rentForm);
    List<Rent> findAll();
    Optional<Rent> findById(RentId rentId);
    void addVehicle(RentId rentId, RentVehicleForm rentVehicleForm) throws RentIdNotExistException;
    void deleteVehicle(RentId rentId, RentVehicleId rentVehicleId) throws RentIdNotExistException, RentVehicleIdNotExistException;

    Optional<String> rentVehicle(VehicleIdDto vehicleIdDto);
}
