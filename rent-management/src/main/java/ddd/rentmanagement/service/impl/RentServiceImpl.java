package ddd.rentmanagement.service.impl;

import ddd.rentmanagement.domain.dto.VehicleIdDto;
import ddd.rentmanagement.domain.exceptions.RentIdNotExistException;
import ddd.rentmanagement.domain.exceptions.RentVehicleIdNotExistException;
import ddd.rentmanagement.domain.model.Rent;
import ddd.rentmanagement.domain.model.RentId;
import ddd.rentmanagement.domain.model.RentVehicleId;
import ddd.rentmanagement.domain.repository.RentRepository;
import ddd.rentmanagement.service.RentService;
import ddd.rentmanagement.service.forms.RentForm;
import ddd.rentmanagement.service.forms.RentVehicleForm;
import ddd.rentmanagement.xport.client.VehicleClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RentServiceImpl implements RentService {

    private final RentRepository rentRepository;
    private final Validator validator;

    private final VehicleClient vehicleClient;

    @Override
    public RentId rent(RentForm rentForm) {
        Objects.requireNonNull(rentForm, "rent must not be null");
        var constraintsViolations = validator.validate(rentForm);
        if(constraintsViolations.size() > 0){
            throw new ConstraintViolationException("The order form is not valid", constraintsViolations);
        }
        var newRent = this.rentRepository.saveAndFlush(toRentObject(rentForm));
        return newRent.getId();
    }

    @Override
    public List<Rent> findAll() {
        return this.rentRepository.findAll();
    }

    @Override
    public Optional<Rent> findById(RentId rentId) {
        return this.rentRepository.findById(rentId);
    }

    @Override
    public void addVehicle(RentId rentId, RentVehicleForm rentVehicleForm) throws RentIdNotExistException {
        Rent rent = this.rentRepository.findById(rentId).orElseThrow(RentIdNotExistException::new);
        rent.addVehicle(rentVehicleForm.getVehicle(), rentVehicleForm.getRentDays());
        this.rentRepository.saveAndFlush(rent);
    }

    @Override
    public void deleteVehicle(RentId rentId, RentVehicleId rentVehicleId) throws RentIdNotExistException, RentVehicleIdNotExistException {
        Rent rent = this.rentRepository.findById(rentId).orElseThrow(RentIdNotExistException::new);
        rent.removeVehicle(rentVehicleId);
        this.rentRepository.saveAndFlush(rent);
    }

    @Override
    public Optional<String> rentVehicle(VehicleIdDto vehicleIdDto) {
        RentVehicleForm rentVehicleForm = new RentVehicleForm();
        rentVehicleForm.setVehicle(vehicleClient.getVehicleWithGivenId(vehicleIdDto.getId()));
        rentVehicleForm.setRentDays(2);

        RentForm rentForm = new RentForm();
        rentForm.setItems(List.of(rentVehicleForm));

        RentId rentId = this.rent(rentForm);
        Rent rent = findById(rentId).orElseThrow(RentIdNotExistException::new);
        return Optional.of("Successfully added");
    }

    private Rent toRentObject(RentForm rentForm){
        var rent = new Rent();
        rentForm.getItems().forEach(item -> rent.addVehicle(item.getVehicle(), item.getRentDays()));
        return rent;
    }
}
