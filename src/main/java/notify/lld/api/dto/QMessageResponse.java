package notify.lld.api.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import notify.lld.domain.enums.PriorityType;
import notify.lld.domain.enums.StatusType;
import notify.lld.utility.Helper;

@Component
@Getter
public class QMessageResponse {

    private String sender, reciever, message, sendTime;

    public StatusType fetchStatus() {
        return Helper.startStatus();
    }

    public PriorityType fetchPriority() {
        return Helper.startPriority();
    }
}
