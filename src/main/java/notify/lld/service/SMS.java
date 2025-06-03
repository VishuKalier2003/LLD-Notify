package notify.lld.service;

import java.util.ArrayDeque;

import org.springframework.stereotype.Component;

import notify.lld.domain.model.QualifiedMessage;

@Component("SMS")
public class SMS implements NotifyStrategy {
    
    @Override
    public void send(QualifiedMessage message) {
        ArrayDeque<QualifiedMessage> q = new ArrayDeque<>();
        q.add(message);
        if(q.isEmpty())
            q.add(null);
    }
}
