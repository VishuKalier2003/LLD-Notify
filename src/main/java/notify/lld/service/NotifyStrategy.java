package notify.lld.service;

import notify.lld.domain.model.RawMessage;

public interface NotifyStrategy {

    public void send(RawMessage message);
}
