package notify.lld.service;

import notify.lld.domain.model.Message;
import notify.lld.service.interfaces.NotifyStrategy;

public class Email implements NotifyStrategy {
    
    @Override
    public void send(Message message) {}
}
