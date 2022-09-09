package ddd.vehiclelist.domain;

import ddd.vehiclelist.domain.models.Vehicle;
import ddd.vehiclelist.domain.models.VehicleId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, VehicleId> {

    Page<Vehicle> findAll(Pageable pageable);

}
