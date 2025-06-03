package notify.lld.domain.messaging;

import java.util.ArrayDeque;

import org.springframework.stereotype.Component;

import lombok.Getter;
import notify.lld.domain.model.QualifiedMessage;

@Component
@Getter
public class StandardQueue<T> implements Messaging<T> {
    
    protected ArrayDeque<QualifiedMessage> standardQueue;

    public StandardQueue() {
        initialize();
    }

    @Override
    public final void initialize() {
        standardQueue = new ArrayDeque<>();
    }

    @Override
    public void pushQueue(T message) {
        if(message instanceof QualifiedMessage rm)
            standardQueue.add(rm);
    }

    @Override
    public boolean isEmpty() {
        return standardQueue.isEmpty();
    }
}
