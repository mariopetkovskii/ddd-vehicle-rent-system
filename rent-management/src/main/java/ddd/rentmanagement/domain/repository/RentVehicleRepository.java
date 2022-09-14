package ddd.rentmanagement.domain.repository;

import ddd.rentmanagement.domain.model.RentVehicle;
import ddd.rentmanagement.domain.model.RentVehicleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentVehicleRepository extends JpaRepository<RentVehicle, RentVehicleId> {
}
