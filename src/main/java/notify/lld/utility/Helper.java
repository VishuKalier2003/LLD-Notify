package notify.lld.utility;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import notify.lld.domain.enums.PriorityType;
import notify.lld.domain.enums.StatusType;

@Component
@Getter
@Setter
public class Helper {

    private static long ID = 1;
    
    public static StatusType startStatus() {
        return StatusType.WAITING;
    }

    public static PriorityType startPriority() {
        return PriorityType.STANDARD;
    }

    public static Long generateID() {
        return ID++;
    }
}
