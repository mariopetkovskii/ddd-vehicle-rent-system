package ddd.sharedkernel.domain.events.users;

import ddd.sharedkernel.domain.config.TopicHolder;
import ddd.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class IncreaseNumRentsUser extends DomainEvent {
    private String userId;

    public IncreaseNumRentsUser() {
        super(TopicHolder.TOPIC_INCREASE_NUM_OF_RENTS);
    }

    public IncreaseNumRentsUser(String userId) {
        super(TopicHolder.TOPIC_INCREASE_NUM_OF_RENTS);
        this.userId = userId;
    }
}
