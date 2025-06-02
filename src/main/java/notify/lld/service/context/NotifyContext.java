package notify.lld.service.context;

import org.springframework.stereotype.Component;

import notify.lld.domain.enums.MessageType;
import notify.lld.service.Email;
import notify.lld.service.interfaces.NotifyStrategy;

// Automatically instantiates it as singleton and can be used as autowiring
@Component
public class NotifyContext {

    private final NotifyStrategy notifyStrategy;
    private final MessageType type;

    public NotifyContext(String t) {
        type = MessageType.valueOf(t.toUpperCase());
        switch(type) {
            case EMAIL -> this.notifyStrategy = new Email();
            default -> this.notifyStrategy = null;
        }
    }
}
