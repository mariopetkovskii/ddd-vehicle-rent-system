package com.example.usersservice.infra;

import com.example.usersservice.domain.models.UserId;
import com.example.usersservice.service.interfaces.UserService;
import ddd.sharedkernel.domain.config.TopicHolder;
import ddd.sharedkernel.domain.events.DomainEvent;
import ddd.sharedkernel.domain.events.rents.RentItemCreated;
import ddd.sharedkernel.domain.events.users.IncreaseNumRentsUser;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DomainEventListener {

    private final UserService userService;

    @KafkaListener(topics = TopicHolder.TOPIC_INCREASE_NUM_OF_RENTS, groupId = "userList")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            IncreaseNumRentsUser event = DomainEvent.fromJson(jsonMessage, IncreaseNumRentsUser.class);
            userService.rentCarIncreaseRents(UserId.of(event.getUserId()));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
