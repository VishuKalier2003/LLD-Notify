package notify.lld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import notify.lld.domain.messaging.ImpQueue;
import notify.lld.domain.messaging.MessageQueue;
import notify.lld.domain.messaging.StandardQueue;
import notify.lld.domain.model.QualifiedMessage;
import notify.lld.domain.repo.QualifiedRepo;

@Service
public class MessagingService {

    @Autowired
    private MessageQueue<QualifiedMessage> messageQueue;

    @Autowired
    private StandardQueue<QualifiedMessage> standardQueue;

    @Autowired
    private QualifiedRepo repo;

    @Autowired
    private ImpQueue<QualifiedMessage> impQueue;

    public boolean pushMessage(QualifiedMessage message) {
        messageQueue.getMessaging().add(message);
        repo.save(message);
        return true;
    }

    public void pushStandardMessage(QualifiedMessage message) {
        standardQueue.getStandardQueue().add(message);
    }

    public void pushImportantMessage(QualifiedMessage message) {
        impQueue.getImpQueue().add(message);
    }
}
