package notify.lld.service.interfaces;

import notify.lld.domain.model.Message;

public interface NotifyStrategy {

    void send(Message message);
}
