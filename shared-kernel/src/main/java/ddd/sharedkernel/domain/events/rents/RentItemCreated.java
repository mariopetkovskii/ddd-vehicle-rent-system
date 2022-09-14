package ddd.sharedkernel.domain.events.rents;

import ddd.sharedkernel.domain.config.TopicHolder;
import ddd.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class RentItemCreated extends DomainEvent {

    private String vehicleId;
    private int daysRent;

    public RentItemCreated() {
        super(TopicHolder.TOPIC_RENT_ITEM_CREATED);
    }

    public RentItemCreated(String vehicleId, int daysRent) {
        super(TopicHolder.TOPIC_RENT_ITEM_CREATED);
        this.vehicleId = vehicleId;
        this.daysRent = daysRent;
    }

}
