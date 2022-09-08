package ddd.rentmanagement.domain.repository;

import ddd.rentmanagement.domain.model.Rent;
import ddd.rentmanagement.domain.model.RentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, RentId> {
}
