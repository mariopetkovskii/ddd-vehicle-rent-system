package ddd.vehiclelist.service;

import ddd.vehiclelist.domain.dto.VehicleIdDto;
import ddd.vehiclelist.domain.models.Vehicle;
import ddd.vehiclelist.domain.models.VehicleId;
import ddd.vehiclelist.service.form.VehicleForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Vehicle findById(VehicleId vehicleId);
    Optional<Vehicle> createVehicle(VehicleForm form);
    Vehicle vehicleItemCreated(VehicleId vehicleId);
    Vehicle vehicleItemRemoved(VehicleId vehicleId);
    List<Vehicle> findAll();
    Page<Vehicle> findAllWithPagination(Pageable pageable);
    Optional <Vehicle> getVehicle(VehicleIdDto vehicleIdDto);

    Optional<Vehicle> rentVehicle(VehicleIdDto vehicleIdDto);

    Optional<Vehicle> unRentVehicle(VehicleIdDto vehicleIdDto);

}
