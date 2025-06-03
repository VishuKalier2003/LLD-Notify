package notify.lld.service;

import notify.lld.domain.model.QualifiedMessage;

public interface NotifyStrategy {

    public void send(QualifiedMessage message);
}
