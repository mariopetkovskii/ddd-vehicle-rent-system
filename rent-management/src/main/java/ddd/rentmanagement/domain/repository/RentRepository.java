package ddd.rentmanagement.domain.repository;

import ddd.rentmanagement.domain.model.Rent;
import ddd.rentmanagement.domain.model.RentId;
import ddd.rentmanagement.domain.model.RentVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, RentId> {
    Rent findByUserId(String userId);
}
