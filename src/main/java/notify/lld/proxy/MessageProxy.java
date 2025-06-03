package notify.lld.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import notify.lld.domain.messaging.MessageQueue;
import notify.lld.domain.model.QualifiedMessage;

@Component
public class MessageProxy {

    private QualifiedMessage QualifiedMessage;

    @Autowired
    private MessageQueue<QualifiedMessage> messageQueue;

    private static final int MAX_SLOTS = 10;

    public boolean preProxy() {
        return !empty() && !heavy();
    }

    private boolean empty() {
        return QualifiedMessage.getMessage().isEmpty();
    }

    private boolean heavy() {
        return messageQueue.getMessaging().size() < MAX_SLOTS;
    }
}
