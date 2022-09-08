package ddd.vehiclelist.service.impl;

import ddd.vehiclelist.domain.VehicleRepository;
import ddd.vehiclelist.domain.exceptions.VehicleNotFoundExceptions;
import ddd.vehiclelist.domain.models.Vehicle;
import ddd.vehiclelist.domain.models.VehicleId;
import ddd.vehiclelist.service.VehicleService;
import ddd.vehiclelist.service.form.VehicleForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle findById(VehicleId vehicleId) {
        return this.vehicleRepository.findById(vehicleId).orElseThrow(VehicleNotFoundExceptions::new);
    }

    @Override
    public Vehicle createVehicle(VehicleForm form) {
        return null;
    }

    @Override
    public Vehicle vehicleItemCreated(VehicleId vehicleId) {
        return null;
    }

    @Override
    public Vehicle vehicleItemRemoved(VehicleId vehicleId) {
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        return this.vehicleRepository.findAll();
    }
}
