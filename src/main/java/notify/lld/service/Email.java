package notify.lld.service;

import org.springframework.stereotype.Component;

import notify.lld.domain.model.QualifiedMessage;

@Component("EMAIL")
public class Email implements NotifyStrategy {

    public Email() {
    }

    @Override
    public void send(QualifiedMessage message) {
    }
}
