package notify.lld.scheduler;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import notify.lld.domain.enums.PriorityType;
import notify.lld.domain.messaging.ImpQueue;
import notify.lld.domain.messaging.MessageQueue;
import notify.lld.domain.messaging.StandardQueue;
import notify.lld.domain.model.QualifiedMessage;

@Component
@EnableScheduling
public class Messaging {
    
    @Autowired
    private MessageQueue<QualifiedMessage> messageQueue;

    @Autowired
    private StandardQueue<QualifiedMessage> standardQueue;

    @Autowired
    private ImpQueue<QualifiedMessage> impQueue;

    @Async
    @Scheduled(fixedDelay=5000)
    public void waitScheduling() {
        if(messageQueue.isEmpty())
            return;
        Instant now = Instant.now();
        while(messageQueue.getMessaging().peek().getTime().isBefore(now)) {
            QualifiedMessage m = messageQueue.getMessaging().poll();
            if(m.getType() == PriorityType.STANDARD)
                standardQueue.pushQueue(m);
            else if(m.getType() == PriorityType.VIP)
                impQueue.pushQueue(m);
        }
    }
}
