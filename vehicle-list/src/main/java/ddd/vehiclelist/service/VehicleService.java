package ddd.vehiclelist.service;

import ddd.vehiclelist.domain.models.Vehicle;
import ddd.vehiclelist.domain.models.VehicleId;
import ddd.vehiclelist.service.form.VehicleForm;

import java.util.List;

public interface VehicleService {

    Vehicle findById(VehicleId vehicleId);
    Vehicle createVehicle(VehicleForm form);
    Vehicle vehicleItemCreated(VehicleId vehicleId);
    Vehicle vehicleItemRemoved(VehicleId vehicleId);
    List<Vehicle> findAll();
}
