package notify.lld.domain.messaging;

import java.util.ArrayDeque;

import org.springframework.stereotype.Component;

import lombok.Getter;
import notify.lld.domain.model.QualifiedMessage;

@Component
@Getter
public class ImpQueue<T> implements Messaging<T> {

    protected ArrayDeque<QualifiedMessage> impQueue;

    public ImpQueue() {
        initialize();
    }
    
    @Override
    public final void initialize() {
        impQueue = new ArrayDeque<>();
    }

    @Override
    public void pushQueue(T message) {
        if(message instanceof QualifiedMessage QualifiedMessage) {
            impQueue.add(QualifiedMessage);
        }
    }

    @Override
    public boolean isEmpty() {
        return impQueue.isEmpty();
    }
}
