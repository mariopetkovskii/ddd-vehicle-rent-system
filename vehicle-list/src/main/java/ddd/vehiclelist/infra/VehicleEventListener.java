package ddd.vehiclelist.infra;


import ddd.sharedkernel.domain.config.TopicHolder;
import ddd.sharedkernel.domain.events.DomainEvent;
import ddd.sharedkernel.domain.events.rents.RentItemCreated;
import ddd.vehiclelist.domain.models.VehicleId;
import ddd.vehiclelist.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleEventListener {
    private final VehicleService vehicleService;

    @KafkaListener(topics = TopicHolder.TOPIC_RENT_ITEM_CREATED, groupId = "vehicleList")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            RentItemCreated event = DomainEvent.fromJson(jsonMessage, RentItemCreated.class);
            vehicleService.vehicleItemCreated(VehicleId.of(event.getVehicleId()));
        } catch (Exception e){

        }
    }

}
