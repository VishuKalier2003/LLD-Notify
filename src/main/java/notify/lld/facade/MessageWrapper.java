package notify.lld.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import notify.lld.api.dto.QMessageResponse;
import notify.lld.domain.model.QualifiedMessage;
import notify.lld.proxy.MessageProxy;
import notify.lld.service.MessagingService;
import notify.lld.utility.Converter;

@Component
public class MessageWrapper {
    
    @Autowired
    private MessageProxy messageProxy;

    @Autowired
    private MessagingService messagingService;

    public boolean fireMessage(QMessageResponse q) {
        QualifiedMessage qm = Converter.convertDtoMessage(q);
        if(messageProxy.preProxy())
            return messagingService.pushMessage(qm);
        return false;
    }
}
