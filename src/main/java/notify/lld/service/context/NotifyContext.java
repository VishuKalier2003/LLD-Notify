package notify.lld.service.context;

import notify.lld.domain.enums.MessageType;
import notify.lld.domain.model.QualifiedMessage;
import notify.lld.service.Email;
import notify.lld.service.NotifyStrategy;
import notify.lld.service.SMS;

// Automatically instantiates it as singleton and can be used as autowiring

public class NotifyContext {

    private final NotifyStrategy notifyStrategy;
    private final MessageType type;

    // If want to use parameters that change at run-time do not define it as bean
    public NotifyContext(String t) {
        type = MessageType.valueOf(t.toUpperCase());
        switch (type) {
            case EMAIL -> this.notifyStrategy = new Email();
            case SMS -> this.notifyStrategy = new SMS();
            default -> this.notifyStrategy = null;
        }
    }

    public void pushNotification(QualifiedMessage message) {
        this.notifyStrategy.send(message);
    }
}
