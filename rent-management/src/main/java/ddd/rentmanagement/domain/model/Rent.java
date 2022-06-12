package ddd.rentmanagement.domain.model;

import ddd.sharedkernel.domain.base.AbstractEntity;
import ddd.sharedkernel.domain.valueobjects.financial.Money;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name="rents")
public class Rent extends AbstractEntity<RentId> {

    private Instant rentedOn;

    private Number daysRent;

    private Money totalCost;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RentVehicle> rentVehicleSet;

    public Rent(){

    }
}
