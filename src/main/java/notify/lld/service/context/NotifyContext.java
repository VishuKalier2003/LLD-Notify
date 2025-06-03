package notify.lld.service.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import notify.lld.domain.enums.MessageType;
import notify.lld.domain.model.RawMessage;
import notify.lld.service.Email;
import notify.lld.service.NotifyStrategy;
import notify.lld.service.SMS;

@SuppressWarnings("unused")
// Automatically instantiates it as singleton and can be used as autowiring
@Component
public class NotifyContext {

    private final NotifyStrategy notifyStrategy;
    private final MessageType type;

    private NotifyContext() {
        this.notifyStrategy = null;
        this.type = null;
    }

    @Autowired
    public NotifyContext(String t) {
        type = MessageType.valueOf(t.toUpperCase());
        switch (type) {
            case EMAIL -> this.notifyStrategy = new Email();
            case SMS -> this.notifyStrategy = new SMS();
            default -> this.notifyStrategy = null;
        }
    }

    public void pushNotification(RawMessage message) {
        this.notifyStrategy.send(message);
    }
}
