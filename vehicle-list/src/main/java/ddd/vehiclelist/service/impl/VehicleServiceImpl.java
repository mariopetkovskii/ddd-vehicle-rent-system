package ddd.vehiclelist.service.impl;

import ddd.vehiclelist.domain.VehicleRepository;
import ddd.vehiclelist.domain.exceptions.VehicleNotFoundException;
import ddd.vehiclelist.domain.models.Vehicle;
import ddd.vehiclelist.domain.models.VehicleId;
import ddd.vehiclelist.service.VehicleService;
import ddd.vehiclelist.service.form.VehicleForm;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle findById(VehicleId vehicleId) {
        return this.vehicleRepository.findById(vehicleId).orElseThrow(VehicleNotFoundException::new);
    }

    @Override
    public Optional<Vehicle> createVehicle(VehicleForm form) {
        Vehicle vehicle = Vehicle.build(form.getName(), form.getBrand(), form.getPrice(), form.getType(), form.getNumOfRents());
        vehicleRepository.save(vehicle);
        return Optional.of(vehicle);
    }

    @Override
    public Vehicle vehicleItemCreated(VehicleId vehicleId) {
        Vehicle vehicle = this.vehicleRepository.findById(vehicleId).orElseThrow(VehicleNotFoundException::new);
        vehicle.addRent();
        this.vehicleRepository.saveAndFlush(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle vehicleItemRemoved(VehicleId vehicleId) {
        Vehicle vehicle = this.vehicleRepository.findById(vehicleId).orElseThrow(VehicleNotFoundException::new);
        vehicle.removeRent();
        this.vehicleRepository.saveAndFlush(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> findAll() {
        return this.vehicleRepository.findAll();
    }

    @Override
    public Page<Vehicle> findAllWithPagination(Pageable pageable) {
        return this.vehicleRepository.findAll(pageable);
    }
}
