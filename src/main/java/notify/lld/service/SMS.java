package notify.lld.service;

import java.util.ArrayDeque;

import notify.lld.domain.model.RawMessage;

public class SMS implements NotifyStrategy {
    
    @Override
    public void send(RawMessage message) {
        ArrayDeque<RawMessage> q = new ArrayDeque<>();
        q.add(message);
        if(q.isEmpty())
            q.add(null);
    }
}
