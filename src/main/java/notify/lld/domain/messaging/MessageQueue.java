package notify.lld.domain.messaging;

import java.util.PriorityQueue;

import org.springframework.stereotype.Component;

import lombok.Getter;
import notify.lld.domain.model.QualifiedMessage;

@Component
@Getter
public class MessageQueue<T> implements Messaging<T> {
    
    protected PriorityQueue<QualifiedMessage> messaging;

    public MessageQueue() {
        initialize();
    }

    @Override
    public final void initialize() {
        messaging = new PriorityQueue<>((a, b) ->
            a.getTime().compareTo(b.getTime())
        );
    }

    @Override
    public void pushQueue(T message) {
        if(message instanceof QualifiedMessage QualifiedMessage)
            messaging.add(QualifiedMessage);
    }

    @Override
    public boolean isEmpty() {
        return messaging.isEmpty();
    }
}
